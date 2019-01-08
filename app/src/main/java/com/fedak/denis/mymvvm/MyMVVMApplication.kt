package com.fedak.denis.mymvvm

import android.app.Activity
import android.app.Application
import com.fedak.denis.mymvvm.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyMVVMApplication : Application(), HasActivityInjector {

    @set:Inject
    var dispatchingAndroidInjector : DispatchingAndroidInjector<Activity>? = null

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .builder()
                .context(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }
}