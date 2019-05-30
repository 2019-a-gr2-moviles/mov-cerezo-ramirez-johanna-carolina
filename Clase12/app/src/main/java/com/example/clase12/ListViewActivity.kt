package com.example.clase12

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.activity_main2.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNames = arrayListOf<String>()
        listaNames.add("Johanna")
        listaNames.add("Carolina")
        listaNames.add("Jose")
        listaNames.add("Alejo")
        listaNames.add("Pedro")
        listaNames.add("Diego")
        listaNames.add("Juan")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,listaNames)
        lv_ejemplo.adapter = adapter

        lv_ejemplo.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i("list-view", "Posicion $position")

            Snackbar.make(view, "Posicion $position", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


    }
}
