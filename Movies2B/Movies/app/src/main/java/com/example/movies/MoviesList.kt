package com.example.movies

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Adapter
import kotlinx.android.synthetic.main.activity_movies_list.*

class MoviesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)

        val lista = Movie.movies
        val recyclerView = rvMovies
        startRecyclerView(lista,this, recyclerView)
        Log.i("RV", "Recyclerview started" )

        btnUserMovies.setOnClickListener {
            goToUserMovies()
        }

    }
    fun goToUserMovies(){
        val intentExplicito = Intent(
            this,
            UserMovies::class.java
        )
        startActivity(intentExplicito)
    }
    fun startRecyclerView(lista: ArrayList<Movie>, actividad:MoviesList, recycler_view: RecyclerView){
        val movieAdapter = AdapterMovie(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = movieAdapter
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)


//        movieAdapter.notifyDataSetChanged()

    }

}
