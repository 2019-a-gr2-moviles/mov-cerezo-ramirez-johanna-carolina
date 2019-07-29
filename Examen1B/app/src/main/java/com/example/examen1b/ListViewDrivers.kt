package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_drivers_crud.*
import kotlinx.android.synthetic.main.activity_list_view_drivers.*

class ListViewDrivers : AppCompatActivity() {

    var driversNamesList = arrayListOf<String>()

    override fun onResume() {
        super.onResume()
        fillNamesList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,driversNamesList)
        listViewDrivers.adapter = adapter
        listViewDrivers.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            goToDriversCrud(position)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_drivers)
        setTitle(R.string.strListViewDriversHeader)
        fillNamesList()


    }

    fun fillNamesList(){
        driversNamesList.clear()
        Driver.driversList.forEach {
            driversNamesList.add(it.name)
        }
    }

    fun goToDriversCrud(id:Int){
        val intent = Intent(this,DriversCrud::class.java)
        intent.putExtra("id",id)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)

    }






}
