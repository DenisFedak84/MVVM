package com.fedak.denis.mymvvm.handler

import com.fedak.denis.mymvvm.model.Car

 interface CarAdapterHandler {
     fun onItemClick(car: Car)
}