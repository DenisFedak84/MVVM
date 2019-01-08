package com.fedak.denis.mymvvm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.fedak.denis.mymvvm.databinding.CarAdapterItemBinding
import com.fedak.denis.mymvvm.handler.CarAdapterHandler
import com.fedak.denis.mymvvm.model.Car

import android.content.Intent
import com.fedak.denis.mymvvm.activity.DetailActivity
import com.fedak.denis.mymvvm.utils.DETAIL_ID

class CarHolder(binding: CarAdapterItemBinding, val context: Context) : RecyclerView.ViewHolder(binding.root), CarAdapterHandler {

    override fun onItemClick(car: Car) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DETAIL_ID, car.id)
        context.startActivity(intent)
    }

    var binding: CarAdapterItemBinding? = binding

    fun bind(car: Car) {
        binding!!.handler = this
        binding?.car = car
        binding?.executePendingBindings()
    }

}