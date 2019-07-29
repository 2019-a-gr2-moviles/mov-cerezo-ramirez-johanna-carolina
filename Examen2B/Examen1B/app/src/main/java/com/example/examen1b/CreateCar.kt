package com.example.examen1b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
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
        val carParams = listOf(
        "chassis" to lyCreateChassisInt.text.toString().toInt(),
        "brandName" to lyCreateBrandNameText.text.toString(),
        "colorOne" to lyCreateColor1Text.text.toString(),
        "colorTwo" to lyCreateColor2Text.text.toString(),
        "modelName" to lyCreateModelNameText.text.toString(),
        "year" to lyCreateYearInt.text.toString().toInt(),
        "long" to "1234",
        "lat" to "56789",
        "fkDriver" to Driver.driversList[id].id
        )
        CarHttpAdapter.createNewCar(carParams,Driver.driversList[id].id, id)
        Log.i("posi","$id")

        // Car.carsList.add(Car(carChassis,carBrandName,carColor1,carColor2,carModelName,year,"1234","12345",(id+1).toString()))
        //${Car.carsList.last().chassis}

        Snackbar.make(it, "${User.currentUser.name} ${getString(R.string.strCreateCar)} ", Snackbar.LENGTH_LONG)
                .show()


    }


}
