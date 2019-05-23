package com.example.clase12

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnParcelable.setOnClickListener {
            irAParceable()
        }
    }

    fun irAParceable(){
        val intentExplicito = Intent(
            this,Parcelable::class.java
        )
        val j = Usuario("Joha",21, Date(),2.0)
        intentExplicito.putExtra("usuario",j)
        val m = Mascota("fucsia",j)
        intentExplicito.putExtra("mascota",m)
        startActivity(intentExplicito)
    }
}
