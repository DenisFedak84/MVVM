package com.fedak.denis.mymvvm.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fedak.denis.mymvvm.R
import com.fedak.denis.mymvvm.databinding.CarAdapterItemBinding
import com.fedak.denis.mymvvm.model.Car


class CarAdapter : RecyclerView.Adapter<CarHolder>() {

    lateinit var cars: List<Car>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val binding: CarAdapterItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.car_adapter_item, parent, false)
        return CarHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return if (::cars.isInitialized) cars.size else 0
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(cars[position])
    }

    fun setData(cars: List<Car>) {
        this.cars = cars
        notifyDataSetChanged()
    }
}