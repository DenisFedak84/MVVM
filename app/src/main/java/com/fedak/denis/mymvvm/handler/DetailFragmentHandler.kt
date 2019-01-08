package com.fedak.denis.mymvvm.handler

import android.view.View
import com.fedak.denis.mymvvm.model.Car

interface DetailFragmentHandler {
    fun onFragmentItemClick (view: View, car : Car)
}