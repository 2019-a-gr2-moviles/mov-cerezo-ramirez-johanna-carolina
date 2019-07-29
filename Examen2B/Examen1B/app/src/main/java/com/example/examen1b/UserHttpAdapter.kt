package com.example.examen1b

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import android.os.AsyncTask



class UserHttpAdapter(){

    fun registerNewUser(name:String){
        val urlCreateUser = "${MainActivity.urlBackend}/user"
        val userParameters = listOf(
            "name" to name
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
                    var user = User(name)
                    User.currentUser = user
                }
            }
        }
    }

}