package com.example.examen1b

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_cars_crud.*
import kotlinx.android.synthetic.main.activity_create_car.*

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
        searchCarForDriver(idDriver)
        val car = carForOwner[id]
        lyCrudChasis.setText(""+car.chassis)
        lyCrudBrandNameText.setText(car.brandname)
        lyCrudColor1Text.setText(car.colorOne)
        lyCrudColor2Text.setText(car.colorDos)
        lyCrudModelNameText.setText(car.modelName)
        lyCrudYear.setText(""+car.year)

    }

    fun deleteCar(id:Int,idDriver:Int,it: View){
        val car = carForOwner[id]
        val driver = Driver.driversList[idDriver]
        driver.carsNummber -= 1
        Snackbar.make(it, "${Driver.actualDriver} ${getString(R.string.strDeleteCar)} ${car.chassis}", Snackbar.LENGTH_LONG)
            .show()
        Car.carsList.remove(car)

    }

    fun searchCarForDriver(id:Int){
        Car.carsList.forEach {
            if(it.driverId == id){
                carForOwner.add(it)
            }
        }
    }


    fun updateCar(id:Int,idDriver:Int,it: View){
        val car = carForOwner[id]
        Car.carsList.forEach {
            if (it.driverId == idDriver  && it.chassis == car.chassis) {
                it.chassis = lyCrudChasis.text.toString().toInt()
                it.modelName =lyCrudModelNameText.text.toString()
                it.brandname = lyCrudBrandNameText.text.toString()
                it.colorOne = lyCrudColor1Text.text.toString()
                it.colorDos = lyCrudColor2Text.text.toString()
                it.year = lyCrudYear.text.toString().toInt()
            }
        }

        Snackbar.make(it, "${Driver.actualDriver} ${getString(R.string.strUpdateCar)} ${car.chassis}", Snackbar.LENGTH_LONG)
            .show()



    }
}
