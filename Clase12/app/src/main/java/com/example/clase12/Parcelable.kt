package com.example.clase12

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parce_label.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parce_label)

        val joha: Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")
        val m:Mascota? = intent.getParcelableExtra<Mascota>("mascota")

        Log.i("parcelable","Nombre:${joha?.nombre}")
        Log.i("parcelable","Nombre:${joha?.edad}")
        Log.i("parcelable","Nombre:${joha?.fechaNacimiento.toString()}")
        Log.i("parcelable","Nombre:${joha?.sueldo}")

        Log.i("parcelable","Nombre:${m?.nombre}")
        Log.i("parcelable","Nombre:${m?.dueno.toString()}")
        btnMenu.setOnClickListener {
            regresarAMenu()
        }
    }

    fun regresarAMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }

}
