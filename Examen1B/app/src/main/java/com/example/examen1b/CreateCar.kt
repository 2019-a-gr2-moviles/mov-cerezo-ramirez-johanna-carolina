package com.example.examen1b

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_create_car.*

class CreateCar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_car)
        setTitle(R.string.strCreateCarHeader)
        val id = intent.getIntExtra("id",0)
        btnSaveCar.setOnClickListener {
            createNewCar(id,it)

        }

    }

    fun createNewCar(id:Int, it: View){
        val carChassis = lyCreateChassisInt.text.toString().toInt()
        val carBrandName = lyCreateBrandNameText.text.toString()
        val carColor1 = lyCreateColor1Text.text.toString()
        val carColor2 = lyCreateColor2Text.text.toString()
        val carModelName = lyCreateModelNameText.text.toString()
        val year = lyCreateYearInt.text.toString().toInt()

        val existscar= Car.carsList.find {
            it.chassis == carChassis
        }

        if (existscar == null){
            Car.carsList.add(Car(carChassis,carBrandName,carColor1,carColor2,carModelName,year,id))
            addCarToDriver(id)
            Snackbar.make(it, "${Driver.actualDriver} ${getString(R.string.strCreateCar)} ${Car.carsList.last().chassis}", Snackbar.LENGTH_LONG)
                .show()
        }else{
            Snackbar.make(it, "${Driver.actualDriver} ${getString(R.string.strCantCreate)} $carChassis ${getString(R.string.strCause)}", Snackbar.LENGTH_LONG)
                .show()
        }

    }

    fun addCarToDriver(id:Int){
        Driver.driversList[id].carsNummber += 1
    }
}
