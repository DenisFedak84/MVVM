package com.fedak.denis.mymvvm.repository

import com.fedak.denis.mymvvm.db.CarDao
import com.fedak.denis.mymvvm.model.Car
import com.fedak.denis.mymvvm.network.CarApi
import javax.inject.Inject


class CarRepository @Inject constructor(private var carApi: CarApi, private var carDao: CarDao) {

    private fun getDataFromServer(): List<Car> {
        return carApi.getPosts().execute().body()!!
    }

    private fun getDataFromDB(): List<Car> {
        return carDao.getAll()
    }

    fun getDataFromDBByID(id: Int): Car {
        return carDao.getById(id.toLong())
    }

    fun getCars(): List<Car> {
        var cars = getDataFromDB()

        if (cars.isEmpty()) {
            cars = getDataFromServer()
            saveCarsInDB(cars)
        }
        return cars
    }

    private fun saveCarsInDB(cars: List<Car>) {
        carDao.insert(*cars.toTypedArray())
    }

    fun getMockData(): List<Car>? {

        val mockCars: MutableList<Car> = ArrayList()
        val url = "https://via.placeholder.com/600/92c952"
        val thumbnailUrl = "https://via.placeholder.com/150/92c952"
        var carOne: Car = Car(1, 1, "Den", url, thumbnailUrl)
        mockCars.add(0, carOne)

        return mockCars
    }

}