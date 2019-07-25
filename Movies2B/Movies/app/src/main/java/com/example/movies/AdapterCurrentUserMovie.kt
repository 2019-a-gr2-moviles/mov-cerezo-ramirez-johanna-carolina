package com.example.movies

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class AdapterCurrentUserMovie(private val moviesList : ArrayList<Movie>,
                              private val contexto: UserMovies,
                              private val recyclerView: RecyclerView
) : RecyclerView.Adapter<AdapterCurrentUserMovie.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nameTextView: TextView
        var yearTextView: TextView
        var priceTextView: TextView
        var imageMovie: ImageView
        var ly: ConstraintLayout


        init {
            nameTextView = view.findViewById(R.id.txtViewMovieName)
            yearTextView = view.findViewById(R.id.txtViewLyMovieYear)
            priceTextView = view.findViewById(R.id.txtViewMoviePrice)
            imageMovie = view.findViewById(R.id.imgMovieInList)
            ly = view.findViewById(R.id.lyMovie)

        }


    }

    override fun onBindViewHolder(myViewHolder: AdapterCurrentUserMovie.MyViewHolder, position: Int) {
        val movie = moviesList[position]

        myViewHolder.nameTextView.text = movie.name
        myViewHolder.yearTextView.text = movie.year
        myViewHolder.priceTextView.text = movie.price
        Glide.with(contexto).load(movie.image).into(myViewHolder.imageMovie)


    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdapterCurrentUserMovie.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.ly_movies,
                p0,
                false
            )


        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}