package com.example.clase15

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorPersona(
    private val listaPersonas: List<Persona>,
    private val contexto: ReciclerViewActivity,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView : TextView
        var cedulaTextView : TextView
        var accionBoton : Button

        init {
            nombreTextView = view.findViewById(R.id.txtNombre) as TextView
            cedulaTextView = view.findViewById(R.id.txtCedula) as TextView
            accionBoton = view.findViewById(R.id.btnAccion) as Button

            val layout = view.findViewById(R.id.linearLayout) as LinearLayout

            layout.setOnClickListener{
                Log.i("recycler view","layout presionado")
            }
        }
    }

// Esta funcion define el templete que vamos a utilizar
    // El template esta en la carpeta de res/layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorPersona.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }


    //Devuelve el numero de items de la lista
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: AdaptadorPersona.MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}