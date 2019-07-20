package com.example.movies

import android.os.AsyncTask
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class UserHttpAdapter : AsyncTask<String, Integer, User?>(){
    val url = "http://172.29.66.179:1337"

    override fun doInBackground(vararg params: String?): User? {

        var currentUrl = "$url/User"

        var email = params[0]
        var password = params[1]
        val body = listOf(
            "email" to email,
            "password" to password
        )
        var usuario : User? = null
        currentUrl
            .httpGet(body)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("testingxd", "Error $ex")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        usuario = Klaxon().parse<User>(data)
                        if (usuario != null) {
                            User.currentUser = usuario!!

                        }
                    }
                }
            }
        return usuario
    }
}