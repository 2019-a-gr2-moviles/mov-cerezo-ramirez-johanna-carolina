package com.example.movies

import android.os.AsyncTask
import android.provider.ContactsContract
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class UserHttpAdapter : AsyncTask<String, Integer, User?>(){


    override fun doInBackground(vararg params: String?): User? {

        var currentUrl = "${MainActivity.urlBackend}/login"

        var email = params[0]
        var password = params[1]
        val body = listOf(
            "email" to email,
            "password" to password
        )
        var usuario : User? = null

        val (request, response, result) = currentUrl
            .httpPost(body)
            .responseString()

        when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                Log.i("testingxd", "Error $ex")
            }
            is Result.Success -> {
                val data = result.get()
                Log.i("testingxd","$data")
                usuario = Klaxon().parse<User>(data)
                if (usuario != null) {
                    User.currentUser = usuario
                    User.currentUserMovieList = getUserMovies()!!

                }
            }
        }

        return usuario
    }

    companion object {
        fun getUserMovies() : ArrayList<Movie>? {

            var currentUserMoviesList : ArrayList<Movie>? = arrayListOf()
            var currentUrl = "${MainActivity.urlBackend}/myMovies?id=${User.currentUser.id}"
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
                                val movieListAux = Klaxon().parseArray<Movie>(data)
                                movieListAux?.forEach {
                                    currentUserMoviesList!!.add(it)
                                }
                            }catch (e : Exception){
                                Log.i("testingxd", "Error buscando movies: $e")
                            }
                        }
                    }
                }
            return currentUserMoviesList

        }
        fun registerNewUser(name:String, lastname:String, email: String,pass:String){
            val urlCreateUser = "${MainActivity.urlBackend}/user"
            val userParameters = listOf(
                "name" to name,
                "lastname" to  lastname,
                "email" to email,
                "password" to pass
            )
            urlCreateUser.httpPost(userParameters).responseString {
                    request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("createUser", "Error: ${error}")
                    }
                    is Result.Success -> {
                        Log.i("createUser", "user created")
                    }
                }
            }

        }

    }



}