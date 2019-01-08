package com.fedak.denis.mymvvm.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.fedak.denis.mymvvm.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        navController = findNavController(R.id.nav_host_fragment)
        navController.setGraph(R.navigation.activity_detail_navigation, intent.extras)


        setSupportActionBar(toolbar)
        initNavDrawer()

        setupActionBar(navController, appBarConfiguration)

        setupNavigationMenu(navController) // добавлен дровер для планшета в landscape

        setupBottomNavMenu(navController)
    }

    private fun initNavDrawer() {
        val drawerLayout: DrawerLayout? = findViewById(R.id.drawer_layout)
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.detailFragment, R.id.deep_link_dest), drawerLayout)
        appBarConfiguration = AppBarConfiguration(setOf(), drawerLayout) // указываем на каких фрагментах не будет стрелки назад
    }

    private fun setupActionBar(navController: NavController, appBarConfig: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

    private fun setupNavigationMenu(navController: NavController) {
        val sideNavView = findViewById<NavigationView>(R.id.nav_view)
        sideNavView?.setupWithNavController(navController)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return item!!.onNavDestinationSelected(findNavController(R.id.nav_host_fragment)) || super.onOptionsItemSelected(
            item
        )
    }

    override fun onSupportNavigateUp(): Boolean {

        if (navController.currentDestination!!.id == R.id.detailFragment){
            finish() // закрываем активити если нажимаешь назад на последнем фрагменте
        }
        return navController.navigateUp(appBarConfiguration)
    }

}