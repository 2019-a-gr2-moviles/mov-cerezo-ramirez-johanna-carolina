package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_manage_drivers.*

class ManageDrivers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_drivers)
        setTitle("${getString(R.string.strMainHeader)}, ${User.currentUser.name}")

        btnCreateDriver.setOnClickListener {
            goToCreateDriver()
        }

        btnManageDrivers.setOnClickListener {
            goToListViewDrivers()
        }
        btnGoToMap.setOnClickListener {
            goToMap()
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

    fun goToMap(){
        var intent = Intent(this,CarsMapsActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
