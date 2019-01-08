package com.fedak.denis.mymvvm.db

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.fedak.denis.mymvvm.model.Car


@Dao
interface CarDao {

    @Query("SELECT * FROM car")
    fun getAll(): List<Car>

    @Query("SELECT * FROM car WHERE id = :id")
    fun getById(id: Long): Car

    @Delete
    fun delete(car: Car)

    @Query("DELETE FROM car")
    fun deleteAll()

    @Insert (onConflict = REPLACE)
    fun insert(vararg car: Car)

    @Update
    fun update(vararg car: Car)

}