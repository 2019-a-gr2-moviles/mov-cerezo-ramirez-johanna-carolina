package com.example.movies

import android.util.Log

class Movie (
    var id: Int,
    var name: String,
    var year: String,
    var price: String,
    var gender: String,
    var sinopsis: String,
    var duration: String,
    var image: String
){

    companion object {
        var movies = arrayListOf<Movie>()
        private var adapter : MovieHttpAdapter = MovieHttpAdapter()

        fun refreshList(){
            //if (adapter.getAll() != null){
                movies = adapter.getAll()!!
            Log.i("load:", "movies loaded")
            //}

        }

    }

}