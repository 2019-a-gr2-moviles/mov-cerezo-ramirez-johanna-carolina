package com.example.app2b

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val lista = arrayListOf<Persona>()
        val recycler_view = rv_personas
        val actividad = this

        lista.add(Persona("José","1805094230"))
        lista.add(Persona("Luis","1805094226"))
        lista.add(Persona("Andrea","1805094222"))

        val adaptadorPersona = AdaptadorPersona(lista, actividad, recycler_view)

        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(this)



    }
}
