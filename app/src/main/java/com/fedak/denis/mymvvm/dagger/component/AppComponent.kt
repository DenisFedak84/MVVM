package com.fedak.denis.mymvvm.dagger.component

import android.content.Context
import com.fedak.denis.mymvvm.MyMVVMApplication
import com.fedak.denis.mymvvm.dagger.module.ActivityModule
import com.fedak.denis.mymvvm.dagger.module.FragmentModule
import com.fedak.denis.mymvvm.dagger.module.NetworkModule
import com.fedak.denis.mymvvm.dagger.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@Component(modules = arrayOf(ActivityModule::class, FragmentModule::class, NetworkModule::class, ViewModelModule::class, AndroidSupportInjectionModule::class))
interface AppComponent {

    fun inject(application: MyMVVMApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}