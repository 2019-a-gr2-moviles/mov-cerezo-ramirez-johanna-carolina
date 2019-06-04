package com.example.examen1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_manage_drivers.*

class ManageDrivers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_drivers)
        setTitle("${getString(R.string.strMainHeader)}, ${Driver.actualDriver}")

        btnCreateDriver.setOnClickListener {
            goToCreateDriver()
        }

        btnManageDrivers.setOnClickListener {
            goToListViewDrivers()
        }

    }

    fun goToListViewDrivers(){
        var intent = Intent(this,ListViewDrivers::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun goToCreateDriver(){
        var intent = Intent(this,CreateDriver::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
