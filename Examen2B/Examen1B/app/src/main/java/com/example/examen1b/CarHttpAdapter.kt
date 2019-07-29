package com.example.examen1b

import android.hardware.Camera
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPut
import java.lang.reflect.Parameter
import java.security.Policy

class CarHttpAdapter {

    companion object {

        fun createNewCar(carParameters : Parameters, driverId:Int, position:Int) {
            val urlCreateDriver = "${MainActivity.urlBackend}/car"

            urlCreateDriver.httpPost(carParameters).responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("createCar", "Error: ${error}")
                    }
                    is Result.Success -> {
                        Log.i("createcar", "car created")
                        DriverHttpAdapter.addCarToDriver(driverId,position)
                        Driver.refreshList()
                    }
                }
            }
        }

        fun deleteCar(carId: Int, position: Int) {
            var currentUrl = "${MainActivity.urlBackend}/Car/$carId"
            currentUrl.httpDelete().responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("deleteCar", "Error: ${error}")
                    }
                    is Result.Success -> {
                        Log.i("deleteCar", "car deleted $carId")
                        DriverHttpAdapter.removeCarFromDriver(position)
                    }
                }
            }
        }

        fun updateCar(carParameters: Parameters, carId:Int) {
            Log.i("carId","$carId")
            var currentUrl = "${MainActivity.urlBackend}/car/$carId"
            currentUrl
                .httpPut(carParameters).responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val error = result.getException()
                            Log.i("updateCar", "Error: ${error}")
                        }
                        is Result.Success -> {
                            Log.i("updateCar", "car updated $carId")
                            Driver.refreshList()

                        }
                    }
                }
        }


        fun getAllCars(): ArrayList<Car>?{
            var currentUrl = "${MainActivity.urlBackend}/Car"

            var carList: ArrayList<Car>? = arrayListOf()
            currentUrl
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("testingxd", "Error: ${ex.message}")
                        }
                        is Result.Success -> {
                            val data = result.get()
                            Log.i("testingxd", data)
                            try {
                                val driverListAux = Klaxon().parseArray<Car>(data)
                                driverListAux?.forEach {
                                    carList!!.add(it)
                                }
                                Car.allCarsList = carList!!
                            } catch (e: Exception) {
                                Log.i("testingxd", "Error buscando users: $e")
                            }
                        }
                    }
                }
            return carList
        }




    }


}