package com.fedak.denis.mymvvm.dagger.module

import com.fedak.denis.mymvvm.activity.DetailActivity
import com.fedak.denis.mymvvm.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity
}