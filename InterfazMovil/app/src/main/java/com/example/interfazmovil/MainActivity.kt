package com.example.interfazmovil

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color.parseColor
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.myToolbar)
        setSupportActionBar(toolbar)

        val lista = arrayListOf<Story>()

        lista.add(Story("@jose",102,R.drawable.boy,R.drawable.foto1,150,12,56,"Esta es una foto genial #Millenial",false))
        lista.add(Story("@caro",230,R.drawable.girl,R.drawable.foto2,200,30,40,"#Paris #Blessed jajajas",false))
        lista.add(Story("@paula",300,R.drawable.girl2,R.drawable.foto3,400,100,50,"No pares de soniar #Travel #Blessed #God",false))
        lista.add(Story("@andres",400,R.drawable.man,R.drawable.foto4,200,30,100,"Supeer paisajee #NiLocoLlegasPorAquiPobre",false))

        iniciarRecyclerView(lista,this,recyclerView)



    }

    fun iniciarRecyclerView(lista: ArrayList<Story>, actividad:MainActivity, recycler_view: RecyclerView){
        val storyAdapter = StoryAdapter(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = storyAdapter
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)


        storyAdapter.notifyDataSetChanged()

    }

}
