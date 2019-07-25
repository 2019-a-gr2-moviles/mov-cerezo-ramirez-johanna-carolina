package com.example.movies

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegisterRe.setOnClickListener {
            createUser()
            Thread.sleep(100)
            logIn()
        }
    }

    fun createUser(){
        var newName = txtInNameRe.text.toString()
        var newLastame = txtInLastnameRe.text.toString()
        var newEmail = txtInEmailRe.text.toString()
        var newPass = txtInPasswordRe.text.toString()
        UserHttpAdapter.registerNewUser(newName,newLastame,newEmail,newPass)
        Log.i("register","user created")
    }

    fun logIn(){
        var newEmail = txtInEmailRe.text.toString()
        var newPass = txtInPasswordRe.text.toString()
        if(User.logIn(newEmail,newPass) != null){
            goToMovies()

        }
    }

    fun goToMovies(){

        val intentExplicito = Intent(
            this,
            MoviesList::class.java
        )
        startActivity(intentExplicito)
    }

}
