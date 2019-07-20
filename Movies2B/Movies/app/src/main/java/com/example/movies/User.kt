package com.example.movies

import android.util.Log

class User(
    var id: Int,
    var name: String,
    var lastname: String,
    var email: String,
    var password: String
) {

    companion object {
        lateinit var currentUser : User
        private var adapter: UserHttpAdapter = UserHttpAdapter()

        fun logIn(email: String, pass: String) : User? {
            var user = adapter.execute(email, pass).get()
            return user
        }
    }
}