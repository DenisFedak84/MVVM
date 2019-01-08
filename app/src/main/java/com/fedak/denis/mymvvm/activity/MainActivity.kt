package com.fedak.denis.mymvvm.activity

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.fedak.denis.mymvvm.R
import com.fedak.denis.mymvvm.databinding.ActivityMainBinding
import com.fedak.denis.mymvvm.utils.toast
import com.fedak.denis.mymvvm.viewmodel.MainViewModel


class MainActivity : BaseActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mainViewModel = getViewModel(this, MainViewModel::class.java)

        binding.viewModel = mainViewModel

        var data = mainViewModel.getCars()
        var error = mainViewModel.getError()

        data?.observe(this, Observer { cars ->
            mainViewModel.finishLoading()
            mainViewModel.refreshAdapter(cars)
        })

        error.observe(this, Observer {
            message ->
            mainViewModel.finishLoading()
            this.toast(message!!) })
    }
}
