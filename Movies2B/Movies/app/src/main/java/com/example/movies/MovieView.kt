package com.example.movies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie.*
import java.text.SimpleDateFormat
import java.util.*

class MovieView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        val idMovie= intent.getIntExtra("movieId",0)
        Log.i("idRecibido", idMovie.toString()
        )
        fillMovieInformation(idMovie)
        btnBuyMovie.setOnClickListener {
            buyMovie(idMovie)
        }
    }

    fun fillMovieInformation(idMovie:Int){
        txtViewMovieTitle.text = Movie.movies[idMovie].name
        txtViewPrice.text = Movie.movies[idMovie].price
        txtViewGender.text = Movie.movies[idMovie].gender
        txtViewDuration.text = Movie.movies[idMovie].duration
        txtViewYear.text = Movie.movies[idMovie].year
        txtViewDescription.text = Movie.movies[idMovie].sinopsis
        Glide.with(this).load(Movie.movies[idMovie].image).into(imgMovie)

    }
    fun buyMovie(idMovie: Int){
        var idMovieStr = (idMovie + 1).toString()
        var idUser = User.currentUser.id.toString()
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val date = Date()
        var dateFinal = sdf.format(date)
        var price = Movie.movies[idMovie].price
        PurchaseHttpAdapter.createPurchase(idUser,idMovieStr,dateFinal,price)

    }
}
