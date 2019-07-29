package com.example.examen1b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_create_driver.*

class CreateDriver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_driver)
        setTitle(R.string.strCreateDriverHeader)
        btnSaveDriver.setOnClickListener {
            createNewDriver()
            Snackbar.make(it, "${Driver.actualDriver} ${getString(R.string.strCreateDriver)} ${Driver.driversList.last().name}", Snackbar.LENGTH_LONG)
                .show()
        }
    }

    fun createNewDriver(){
        val driverName = lyCreateNameText.text.toString()
        val driverLastname = lyCreateLastNameText.text.toString()
        val driverBirthDate = lyCreateBirthDateText.text.toString()
        val driverLicense = checkBoxCreateValidLicense.isChecked
        Driver.driversList.add(Driver(driverName,driverLastname,driverBirthDate,0,driverLicense))
       /* Log.i("New Driver","${driverName}")
        Driver.driversList.forEach {
            Log.i("Driver","${it.name}")
        }*/

    }

}




