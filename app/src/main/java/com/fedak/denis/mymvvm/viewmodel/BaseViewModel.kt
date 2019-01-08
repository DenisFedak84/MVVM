package com.fedak.denis.mymvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import java.util.concurrent.Executor
import java.util.concurrent.Executors

open class BaseViewModel(application : Application) : AndroidViewModel(application){

    val executor: Executor
    lateinit var loadError: MutableLiveData<String>

    init {
        executor = Executors.newSingleThreadExecutor()
    }

    fun getError(): MutableLiveData<String> {
        loadError  = MutableLiveData()
        return loadError
    }
}