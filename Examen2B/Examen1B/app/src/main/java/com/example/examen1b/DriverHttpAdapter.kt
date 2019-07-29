package com.example.examen1b

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.*
import com.github.kittinunf.result.Result
import java.lang.reflect.Parameter
import java.text.FieldPosition

class DriverHttpAdapter {

    companion object {


        fun createNewDriver(name: String, lastname: String, birthDate: String,carsNumber: Int, license: Boolean) {
            val urlCreateDriver = "${MainActivity.urlBackend}/driver"
            val userParameters = listOf(
                "name" to name,
                "lastname" to lastname,
                "carsNumber" to carsNumber,
                "birthDate" to birthDate,
                "license" to license
            )
            urlCreateDriver.httpPost(userParameters).responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("createUser", "Error: ${error}")
                    }
                    is Result.Success -> {
                        Log.i("createUser", "user created")
                        Driver.refreshList()
                    }
                }
            }
        }


        fun getAllDrivers(): ArrayList<Driver>? {
            var currentUrl = "${MainActivity.urlBackend}/Driver"

            var driverList: ArrayList<Driver>? = arrayListOf()
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
                                val driverListAux = Klaxon().parseArray<Driver>(data)
                                driverListAux?.forEach {
                                    driverList!!.add(it)
                                }
                                Driver.driversList = driverList!!
                            } catch (e: Exception) {
                                Log.i("testingxd", "Error buscando users: $e")
                            }
                        }
                    }
                }
            return driverList
        }



        fun addCarToDriver( driverId: Int, position: Int) {

            var currentUrl = "${MainActivity.urlBackend}/Driver/$driverId"
            var newCarsNumber:Int
            if(Driver.driversList[position].hasCars.size != null) {
                newCarsNumber = Driver.driversList[position].hasCars.size + 1
            }else{
                newCarsNumber = 1
            }

            Log.i("driverId", "$driverId")
            val body = listOf(
                "carsNumber" to newCarsNumber
            )

            currentUrl
                .httpPut(body).responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val error = result.getException()
                            Log.i("addCarToUser", "Error: ${error}")
                        }
                        is Result.Success -> {
                            Log.i("addCarToUser", "car added to driver $driverId")
                            Driver.refreshList()

                        }
                    }
                }
        }


        fun removeCarFromDriver(position: Int) {

            var currentUrl = "${MainActivity.urlBackend}/Driver/${Driver.driversList[position].id}"
            var newCarsNumber:Int
            if(Driver.driversList[position].hasCars.size != null) {
                newCarsNumber = Driver.driversList[position].hasCars.size - 1
            }else{
                newCarsNumber = 0
            }
            Log.i("driverId", "${Driver.driversList[position].id}")
            val body = listOf(
                "carsNumber" to newCarsNumber
            )
            currentUrl
                .httpPut(body).responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val error = result.getException()
                            Log.i("addCarToUser", "Error: ${error}")
                        }
                        is Result.Success -> {
                            Log.i("addCarToUser", "car added to driver ")
                            Driver.refreshList()

                        }
                    }
                }
        }


        fun updateDriver(driverId: Int, name: String, lastname: String, birthDate: String, license: Boolean) {
            Log.i("driverid","$driverId")
            var currentUrl = "${MainActivity.urlBackend}/driver/$driverId"
            val driverParameters = listOf(
                "name" to name,
                "lastname" to lastname,
                "birthDate" to birthDate,
                "license" to license
            )

            currentUrl
                .httpPut(driverParameters).responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val error = result.getException()
                            Log.i("updateDriver", "Error: ${error}")
                        }
                        is Result.Success -> {
                            Log.i("updateDriver", "driverUpdated $driverId")
                            Driver.refreshList()

                        }
                    }
                }
        }

        fun deleteDriver(driverId: Int) {
            var currentUrl = "${MainActivity.urlBackend}/Driver/$driverId"
            currentUrl.httpDelete().responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("deleteDriver", "Error: ${error}")
                    }
                    is Result.Success -> {
                        Log.i("deleteDriver", "driver deleted $driverId")
                        Driver.refreshList()

                    }
                }
            }
        }

    }
}