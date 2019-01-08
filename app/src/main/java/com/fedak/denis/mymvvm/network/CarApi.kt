package com.fedak.denis.mymvvm.network

import com.fedak.denis.mymvvm.model.Car
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface CarApi {
    /**
     * Get the list of the pots from the API
     */

    @GET("/photos")
    fun getPosts(): Call<List<Car>>
}