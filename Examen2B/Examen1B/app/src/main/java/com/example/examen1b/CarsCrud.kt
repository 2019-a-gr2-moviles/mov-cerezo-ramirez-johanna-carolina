package com.example.examen1b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_cars_crud.*

class CarsCrud : AppCompatActivity() {

    val carForOwner = arrayListOf<Car>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars_crud)
        setTitle(R.string.srtCarsCrudHeader)
        val id = intent.getIntExtra("id",0)
        val idDriver = intent.getIntExtra("idDriver",0)
        Log.i("id","$id")
        fillTextLayout(id,idDriver)

        btnDeleteCar.setOnClickListener {
            deleteCar(id, idDriver,it)
        }

        btnUpdateCar.setOnClickListener {
            updateCar(id, idDriver,it)
        }
    }

    fun fillTextLayout(id:Int,idDriver: Int){

        lyCrudChasis.setText(""+Driver.driversList[idDriver].hasCars[id].chassis)
        lyCrudBrandNameText.setText(Driver.driversList[idDriver].hasCars[id].brandName)
        lyCrudColor1Text.setText(Driver.driversList[idDriver].hasCars[id].colorOne)
        lyCrudColor2Text.setText(Driver.driversList[idDriver].hasCars[id].colorTwo)
        lyCrudModelNameText.setText(Driver.driversList[idDriver].hasCars[id].modelName)
        lyCrudYear.setText(""+Driver.driversList[idDriver].hasCars[id].year)

    }

    fun deleteCar(id:Int,idDriver:Int,it: View){

        val driver = Driver.driversList[idDriver]
        driver.carsNumber -= 1
        Snackbar.make(it, "${User.currentUser.name} ${getString(R.string.strDeleteCar)} ", Snackbar.LENGTH_LONG)
            .show()
        CarHttpAdapter.deleteCar(Driver.driversList[idDriver].hasCars[id].id,idDriver)

    }


    fun updateCar(id:Int,idDriver:Int,it: View){
        var body = listOf(
            "chassis" to lyCrudChasis.text.toString().toInt(),
            "modelName" to lyCrudModelNameText.text.toString(),
            "brandName" to lyCrudBrandNameText.text.toString(),
            "colorOne" to lyCrudColor1Text.text.toString(),
            "colorTwo" to lyCrudColor2Text.text.toString(),
            "year" to lyCrudYear.text.toString().toInt()
        )
        CarHttpAdapter.updateCar(body,Driver.driversList[idDriver].hasCars[id].id)

        Snackbar.make(it, "${User.currentUser.name} ${getString(R.string.strUpdateCar)} ", Snackbar.LENGTH_LONG)
            .show()



    }
}
