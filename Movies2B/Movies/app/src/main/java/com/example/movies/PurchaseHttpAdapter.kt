package com.example.movies

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class PurchaseHttpAdapter {
    val url = "http://172.29.66.179:1337"

    fun getAll() : List<Purchase>? {
        var currentUrl = "${MainActivity.urlBackend}/purchase"

        var purchaseList : ArrayList<Purchase>? = arrayListOf()
        currentUrl
            .httpGet()
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("testingxd", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("testingxd",data)
                        try {
                            val purchaseListAux = Klaxon().parseArray<Purchase>(data)
                            purchaseListAux?.forEach {
                                purchaseList!!.add(it)
                            }
                            Purchase.purchases = purchaseList!!
                        }catch (e : Exception){
                            Log.i("testingxd", "Error buscando purchases: $e")
                        }
                    }
                }
            }
        return purchaseList
    }

    companion object {
        fun createPurchase(idUser:String,idMovie: String, date:String,price:String){
            val urlCreatePurchase= "${MainActivity.urlBackend}/purchase"

            val purchaseParametes = listOf(
                "fkUser" to idUser,
                "fkMovie" to idMovie,
                "datePurchase" to date,
                "price" to price

            )

            urlCreatePurchase.httpPost(purchaseParametes).responseString {
                request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("createPurchase", "Error: ${error}")
                    }
                    is Result.Success -> {
                        Log.i("createPurchase", "purchase created")
                        User.currentUserMovieList = UserHttpAdapter.getUserMovies()!!
                    }
                }
            }
        }
    }
}