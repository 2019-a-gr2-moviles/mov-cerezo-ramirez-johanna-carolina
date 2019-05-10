package Model

import Controller.RdWrFiles

public class Movie(val id: String,
                   var name:String,
                   var date:String,
                   var director: String,
                   var price:String,
                   var gender:String) {

    init {
        var lines = RdWrFiles

    }


     fun propertiesStr(): String {
        val str = this.id+","+this.name+","+this.date+","+this.director+","+this.price+","+this.gender
        return str

    }

    companion object{
        fun propertiesNames(): Array<String> {
            val columnNames = arrayOf("Id","Nombre","Fecha","Directores","Precio","Genero")
            return columnNames
        }
        var moviesList: ArrayList<Movie>? = ArrayList()

        fun createFromDB(){
            val aux: ArrayList<Movie>? = ArrayList()
            val lines = RdWrFiles.readFile("src/Database/Movies")
            lines.forEach{
                val property= it.split(",")
                val movie =  Movie(property[0],property[1],property[2],property[3],property[4],property[5])
                aux!!.add(movie)
            }
            moviesList = aux

        }

        fun getMoviesAtributtes(): ArrayList<String>? {
            var attributesMoviesList : ArrayList<String>? = ArrayList()
            moviesList!!.forEach {it
                attributesMoviesList!!.add(it.propertiesStr())
            }

            return attributesMoviesList

        }
    }

    fun saveToDB(){
        print(propertiesStr())
        RdWrFiles.writeFile("src/Database/Movies",propertiesStr())

    }



}