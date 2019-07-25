package com.example.movies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movies_list.*
import kotlinx.android.synthetic.main.activity_user_movies.*

class UserMovies : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_movies)
        val lista = User.currentUserMovieList
        val recyclerView = rvCurrentUserMovies
        startRecyclerView(lista,this, recyclerView)
        txtViewCurrentUserNameUM.text = User.currentUser.name
    }

    fun startRecyclerView(lista: ArrayList<Movie>, actividad:UserMovies, recycler_view: RecyclerView){
        val currenUserMoviesAdapter = AdapterCurrentUserMovie(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = currenUserMoviesAdapter
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)


//        movieAdapter.notifyDataSetChanged()

    }
}
