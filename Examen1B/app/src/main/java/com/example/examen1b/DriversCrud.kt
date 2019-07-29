package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_drivers_crud.*

class DriversCrud : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        val id = intent.getIntExtra("id",0)
        fillTextLayouts(id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drivers_crud)
        setTitle(R.string.strDriversCrudHeader)
        val id = intent.getIntExtra("id",0)
        fillTextLayouts(id)

        btnCreateCar.setOnClickListener {
            goToCreateCar(id)
        }

        btnManageCars.setOnClickListener {
            goToListViewCars(id)
        }

        btnDeleteDriver.setOnClickListener {
            deleteDriver(id,it)

        }
        btnUpadateDriver.setOnClickListener {
            updateDriver(id, it)
        }

    }

    fun fillTextLayouts(id: Int){
        val driver = Driver.driversList[id]
        lyCrudNameText.setText(driver.name)
        lyCrudLastnameText.setText(driver.lastName)
        lyCrudBirthDateText.setText(driver.birthDate)
        lyCrudCarsNumberText.setText(driver.carsNummber.toString())
        lyCrudCarsNumberText.isEnabled = false
        checkBoxCrudLicense.isChecked = driver.license
    }

    fun goToCreateCar(id:Int){
        val intent = Intent(this,CreateCar::class.java)
        intent.putExtra("id",id)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun goToListViewCars(id:Int){
        val intent = Intent(this,ListViewCars::class.java)
        intent.putExtra("id",id)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun deleteDriver(id:Int, it:View){
        val driver = Driver.driversList[id]
        val carsToDelete = arrayListOf<Car>()
        Car.carsList.forEach {
            if(it.driverId == id){
                carsToDelete.add(it)
            }
        }
        for( i in carsToDelete){
            Car.carsList.remove(i)
        }

        Snackbar.make(it, "${Driver.actualDriver} ${getString(R.string.strDeleteDriver)} ${Driver.driversList[id].name}", Snackbar.LENGTH_LONG)
            .show()
        Driver.driversList.remove(driver)

    }

    fun updateDriver(id:Int, it:View){
        val driver = Driver.driversList[id]
        driver.name = lyCrudNameText.text.toString()
        driver.lastName = lyCrudLastnameText.text.toString()
        driver.birthDate = lyCrudBirthDateText.text.toString()
        driver.license = checkBoxCrudLicense.isChecked

        Snackbar.make(it, "${Driver.actualDriver} ${getString(R.string.strUpdateDriver)} ${Driver.driversList[id].name}", Snackbar.LENGTH_LONG)
            .show()

    }

}
