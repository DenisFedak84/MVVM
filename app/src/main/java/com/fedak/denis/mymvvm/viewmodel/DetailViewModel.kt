package com.fedak.denis.mymvvm.viewmodel

import android.app.Application
import android.content.Context
import android.databinding.ObservableField
import com.fedak.denis.mymvvm.model.Car
import com.fedak.denis.mymvvm.repository.CarRepository
import javax.inject.Inject

class DetailViewModel @Inject constructor(context: Context) : BaseViewModel(context as Application) {

    @Inject
    lateinit var carRepository: CarRepository

    var car: ObservableField<Car> = ObservableField()

    var url: String? = "default url"

    fun loadCar(id: Int) {
        executor.execute {
            try {
                val carDB = carRepository.getDataFromDBByID(id)
                url = carDB.thumbnailUrl
                car.set(carDB) // стартуем биндинг
            } catch (e: Exception) {
                loadError.postValue("Loading Erorr")
            }
        }
    }
}