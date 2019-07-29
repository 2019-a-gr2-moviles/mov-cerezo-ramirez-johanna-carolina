package com.example.examen1b

import android.util.Log

class Car (var id: Int,
            var chassis : Int,
           var brandName: String,
           var colorOne : String,
           var colorTwo: String,
           var modelName: String,
           var year: Int,
           var long : String,
           var lat : String) {

    companion object {
        var allCarsList = arrayListOf<Pair<Car, Int>>()


        fun getAllCars(){
            Log.i("carsList","$allCarsList")
            Driver.driversList.forEachIndexed { index, driver ->
                Log.i("carsList","${driver.name}")
               driver.hasCars.forEach {
                   Log.i("carsList","${it.modelName}")
                   allCarsList.add(it to index)
                   Log.i("carsList","$allCarsList")
               }
            }
        }
    }

}