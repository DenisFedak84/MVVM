package com.fedak.denis.mymvvm.fragment

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.fedak.denis.mymvvm.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class  BaseFragment : DaggerFragment() {

    @set:Inject
    var viewModelProviderFactory: ViewModelProviderFactory? = null

    protected fun <T : ViewModel> getViewModel(target: FragmentActivity, viewModelClass: Class<T>): T {
        return ViewModelProviders.of(target, viewModelProviderFactory).get(viewModelClass)
    }
}