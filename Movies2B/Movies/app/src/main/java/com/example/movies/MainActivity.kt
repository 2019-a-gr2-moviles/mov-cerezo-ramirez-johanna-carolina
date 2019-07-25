package com.example.movies

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movies_list.*

class MainActivity : AppCompatActivity() {

    companion object{
        val urlBackend = "http://192.168.1.144:1337"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Movie.refreshList()
        Purchase.refreshList()
        btnRegisterSI.setOnClickListener {
            goToRegister()
        }
        btnSignIn.setOnClickListener {
            logIn()
        }


    }

    fun goToRegister(){
        val intentExplicito = Intent(
            this,
            Register::class.java
        )
        startActivity(intentExplicito)
    }

    fun goToMovies(){

        val intentExplicito = Intent(
            this,
            MoviesList::class.java
        )
        startActivity(intentExplicito)
    }

    fun logIn(){
        var emailIn = txtInputEmailSI.text.toString()
        var passIn = txtInputPassSI.text.toString()
        if(User.logIn(emailIn,passIn) != null){
            goToMovies()

        }
    }




}
