package com.example.movies

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide


class AdapterMovie(private val moviesList : ArrayList<Movie>,
                   private val contexto: MoviesList,
                   private val recyclerView: RecyclerView
) : RecyclerView.Adapter<AdapterMovie.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nameTextView: TextView
        var yearTextView: TextView
        var priceTextView: TextView
        var imageMovie: ImageView


        init {
            nameTextView = view.findViewById(R.id.txtViewMovieName)
            yearTextView = view.findViewById(R.id.txtViewMovieYear)
            priceTextView = view.findViewById(R.id.txtViewMoviePrice)
            imageMovie= view.findViewById(R.id.imgMovieInList)

        }


    }

    override fun onBindViewHolder(myViewHolder: AdapterMovie.MyViewHolder, position: Int) {
        val movie = moviesList[position]

        myViewHolder.nameTextView.text = movie.name
        myViewHolder.yearTextView.text = movie.year
        myViewHolder.priceTextView.text = movie.price
        Glide.with(contexto).load(movie.image).into(myViewHolder.imageMovie)

    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdapterMovie.MyViewHolder {
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
