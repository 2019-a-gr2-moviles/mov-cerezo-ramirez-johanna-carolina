package com.example.examen1b

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import android.os.AsyncTask



class UserHttpAdapter() : AsyncTask<String, Integer, User?>(){

    override fun doInBackground(vararg params: String?): User? {

        var currentUrl = "${MainActivity.urlBackend}/login"

        var name = params[0]

        val body = listOf(
            "name" to name
        )
        var usuario : User? = null

        val (request, response, result) = currentUrl
            .httpPost(body)
            .responseString()

        when (result) {
            is Result.Failure-> {
                val ex = result.getException()
                Log.i("testingxd", "Error $ex")
            }
            is Result.Success -> {
                val data = result.get()
                Log.i("testingxd","$data")
                usuario = Klaxon().parse<User>(data)
                if (usuario != null) {
                    User.currentUser = usuario
                }
            }
        }

        return usuario
    }
}