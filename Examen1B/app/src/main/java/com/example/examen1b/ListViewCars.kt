package com.example.examen1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_cars.*
import kotlinx.android.synthetic.main.activity_list_view_drivers.*

class ListViewCars : AppCompatActivity() {

    var carsDriverList = arrayListOf<String>()

    override fun onResume() {
        super.onResume()
        val idDriver = intent.getIntExtra("id",0)
        fillChassisList(idDriver)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,carsDriverList)
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

    }

    fun fillChassisList(id:Int){
        carsDriverList.clear()
        Car.carsList.forEach {
            if(it.driverId == id){
                carsDriverList.add(it.modelName)
            }
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
