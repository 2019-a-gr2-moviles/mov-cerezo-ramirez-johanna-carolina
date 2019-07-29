package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val urlBackend = "http://192.168.1.144:1337"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.strMainHeader)
        Driver.refreshList()
        Car.refreshList()
        btnIn.setOnClickListener {
            logIn()
        }
    }

    fun goToManageDrivers(){

        val intent = Intent(this,ManageDrivers::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun logIn(){
        var name = lyInName.text.toString()
        User.logIn(name)
        if(User.currentUser != null){
            goToManageDrivers()
        }
    }



}
