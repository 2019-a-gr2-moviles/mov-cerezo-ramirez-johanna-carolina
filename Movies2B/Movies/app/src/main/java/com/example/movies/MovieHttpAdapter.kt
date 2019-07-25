package com.example.movies
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class MovieHttpAdapter {

    val url = "http://172.29.66.179:1337"

    fun getAll() : ArrayList<Movie>? {
        var currentUrl = "${MainActivity.urlBackend}/Movie"

        //var currentUrl = "${MainActivity.urlBackend}/myMovies?id=${User.currentUser.id}"

        var movieList : ArrayList<Movie>? = arrayListOf()
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
                                movieList!!.add(it)
                            }
                            Movie.movies = movieList!!
                        }catch (e : Exception){
                            Log.i("testingxd", "Error buscando movies: $e")
                        }
                    }
                }
            }
        return movieList
    }




}