package com.example.examen1b

class Car (var chassis : Int,
           var brandname: String,
           var colorOne : String,
           var colorDos: String,
           var modelName: String,
           var year: Int,
           var driverId:Int) {

    companion object {
        var carsList = arrayListOf<Car>(
            Car(15597,"Toyota","negro","azul","corolla",2018,0),
            Car(15598,"Ford","rojo","negro","explorer",2015,0),
            Car(14475,"BMW","rojo","negro","mmmm",2015,1),
            Car(15675,"Mazda","rojo","negro","nnnnn",2015,1),
            Car(13575,"Mazda","rojo","negro","ooooo",2016,2),
            Car(15975,"Ford","rojo","negro","pppppp",2017,2),
            Car(13275,"Audi","rojo","negro","oooooo",2018,3),
            Car(14475,"Honda","rojo","negro","qqqqq",2019,4)
        )
    }

}