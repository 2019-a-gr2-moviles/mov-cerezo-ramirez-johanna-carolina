package com.example.examen1b

import android.util.Log
import java.util.ArrayList

class Driver(var id : Int,
            var name : String,
             var lastname: String,
             var birthDate: String,
             var carsNumber: Int,
             var license : Boolean,
             var hasCars: ArrayList<Car> ) {

    companion object {
        var driversList = arrayListOf<Driver>()

        /*(
            Driver("Johanna","Cerezo","01/11/1997",2,true),
            Driver("Paula","Cerezo","21/11/1998",2,false),
            Driver("Elvis","Beta","07/06/1996",2,true),
            Driver("Juan","Sulca","16/04/1997",1,true),
            Driver("Jose","Murillo","07/01/1998",1,true),
            Driver("Anna","Ramirez","02/11/1997",0,true),
            Driver("Marco","Perez","01/05/1998",0,false))*/

        fun refreshList(){
            driversList = DriverHttpAdapter.getAllDrivers()!!
            Log.i("load:", "movies loaded")

        }








    }


}


