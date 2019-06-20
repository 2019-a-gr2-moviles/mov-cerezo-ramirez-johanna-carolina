package com.example.app2b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_recycler.setOnClickListener {
            irARecycler()
        }

    }

    fun irARecycler(){
        val intent = Intent(
            this,
            RecyclerViewActivity :: class.java
        )
        startActivity(intent)
    }



}
