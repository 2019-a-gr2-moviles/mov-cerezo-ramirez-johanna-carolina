package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_cars.*

class ListViewCars : AppCompatActivity() {

    var carsDriversModelNameList = arrayListOf<String>()

    override fun onResume() {
        super.onResume()
        val idDriver = intent.getIntExtra("id",0)
        fillChassisList(idDriver)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,carsDriversModelNameList)
        listViewCars.adapter = adapter
        listViewCars.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            goToCarsCrud(position,idDriver)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_cars)
        setTitle(getString(R.string.strListViewCarsHeader))
        val idDriver = intent.getIntExtra("id",0)
        fillChassisList(idDriver)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,carsDriversModelNameList)

    }

    fun fillChassisList(driverId:Int){
        carsDriversModelNameList.clear()
        var actualDriverCarList : ArrayList<Car> = Driver.driversList[driverId].hasCars
        Thread.sleep(100)
        actualDriverCarList.forEach{
            Log.i("modelnameEX","${it.modelName}")
             carsDriversModelNameList.add(it.modelName)

        }
    }





    fun goToCarsCrud(id:Int,idDriver:Int){
        val intent = Intent(this,CarsCrud::class.java)
        intent.putExtra("id",id)
        intent.putExtra("idDriver",idDriver)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


}
