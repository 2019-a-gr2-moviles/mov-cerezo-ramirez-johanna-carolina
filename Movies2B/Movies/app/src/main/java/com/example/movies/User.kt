package com.example.movies

import android.util.Log

class User(
    var id: Int,
    var name: String,
    var lastname: String,
    var email: String
    //var password: String
    //var userMovies : ArrayList<Movie>
) {

    companion object {
        lateinit var currentUser : User
        lateinit var currentUserMovieList  : ArrayList<Movie>
        private var adapter: UserHttpAdapter = UserHttpAdapter()

        fun logIn(email: String, pass: String) : User? {
            var user = adapter.execute(email, pass).get()
            return user
        }


    }
}