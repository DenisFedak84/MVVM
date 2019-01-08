package com.fedak.denis.mymvvm.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.fedak.denis.mymvvm.model.Car

@Database(entities = [Car::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}