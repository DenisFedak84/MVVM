package com.fedak.denis.mymvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.view.View
import com.fedak.denis.mymvvm.adapter.CarAdapter
import com.fedak.denis.mymvvm.model.Car
import com.fedak.denis.mymvvm.repository.CarRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel @Inject constructor(context: Context) : BaseViewModel(context as Application) {

    @Inject
    lateinit var carRepository: CarRepository

    lateinit var data: MutableLiveData<List<Car>>

    val carAdapter: CarAdapter = CarAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()


    fun getCars(): MutableLiveData<List<Car>>? {

        startLoading()
        data = MutableLiveData()
        loadCars()

        return data
    }

    private fun loadCars() {
        executor.execute {
            try {
                data.postValue(carRepository.getCars())
            } catch (e: Exception) {
                loadError.postValue("Loading Erorr")
            }
        }
    }

    private fun testUpdateData() {
        TimeUnit.SECONDS.sleep(2)
        data.postValue(carRepository.getMockData())
    }

    private fun startLoading() {
        loadingVisibility.value = View.VISIBLE
    }

    fun finishLoading() {
        loadingVisibility.value = View.GONE
    }

    fun refreshAdapter(cars: List<Car>?) {
        if (cars != null) {
            carAdapter.setData(cars)
        }
    }

}