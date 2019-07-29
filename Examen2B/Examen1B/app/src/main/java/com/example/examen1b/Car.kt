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
        var allCarsList = arrayListOf<Car>()


        fun refreshList(){
            allCarsList = CarHttpAdapter.getAllCars()!!
            Log.i("load:", "cars loaded")
        }
    }

}