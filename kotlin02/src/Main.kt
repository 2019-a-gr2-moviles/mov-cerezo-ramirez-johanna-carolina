fun main(args : Array<String>){
    println("Hello, world")

// Definir variable:
    // Variables mutables:
        var nombre = "Adrian"
        nombre = "pedro"

    // Variables inmutables:
        val nombreI = "Adrian"
        //nombreI = "Ana"
    //La mejor manera de declarar variables es que todo sea inmutable
    //Porque asi se evitan errores de cambio de tipo

    val apellido: String = "Cerezo"
    val edad: Int = 29
    val sueldo: Double = 1234.444
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos: Nothing? = null

    if (apellido == "Eguez"){
        println("verdadero")
    }else{
        println("falso")
    }

    val tieneNombreYApellido= if(apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreYApellido)

    estaJalado(8.0)
    estaJalado(1.0)
    estaJalado(0.0)
    estaJalado(10.0)
    estaJalado(7.0)

    holaMundo(nombre)
    holaMundoAvanzado(3)
    sumarDosnUmeros(2,5)
    val total = sumarDosnUmeros(2,5)
    print(total)

    val arregloCumpleanos = arrayOf(1, 2, 3, 4)
    val arregloTodo = arrayOf(1, "dos", 5.0, 4)

    arregloCumpleanos[0] = 5
    arregloCumpleanos.set(0,5)


    //val fecha = Date()
    //fecha.time = 11231231
    //fecha.year = 2000

    val notas = arrayListOf(1, 2, 3, 4, 5, 6)

    //For each :: iterar areglos:
    notas.forEach{nota ->
        println(nota)
    }

    notas.forEachIndexed { indice, nota ->
        println("Indice: $indice")
        println("nota: $nota")

    }


    // Operador MAP: itera y modifica el arreglo

    val notasDos = notas.map {nota ->
        nota + 1
    }

    notasDos.forEach{
        println("Notas 2: $it")
    }

    val notasTres = notas.map{nota ->
        if(nota%2 == 0){
            nota + 2
        }else{
            nota +1
        }
    }

    val notasCuatro = notas.map {nota->
        val modulo = nota%2
        val esPar = 0
        when (modulo){
            esPar -> {
                nota + 2
            }else ->{
            nota + 1
        }
        }
    }

    //FILTER

    val respuestaFilter = notas.filter{
        it > 2
    }

    respuestaFilter.forEach{ println(it)}


    val respuestaFilter2 = notas.filter{
        it in 3..4
        // it > 2 && it < 4
    }.map {
        it * 2
    }

    val novias = arrayListOf(1, 2, 2, 3, 4, 5)


    //Any
    val respuestaNovia = novias.any{
        it == 3
    }

    println(respuestaNovia)

        // All
    val tazos = arrayListOf(1,2,3,4,5,6,7)
    val respuestaTazos = tazos.all{
        it>1
    }
    println(respuestaTazos) //devuelve falso

    //REDUCE

    val totalTazo = tazos.reduce{valorAcumulado, tazo ->
        valorAcumulado + tazo
    }

    println(totalTazo) //Devuelve la suma de los tazos


}

fun estaJalado(nota:Double){
    when (nota) {
        7.0 -> {
            println("pasate con las justas")
        }
        10.0 -> {
            println("Felicitaciones")
        }
        0.0 -> {
            println("Vago!!")
        }
        else -> {
            println("Tu nota es: ${nota}")
            println("Tu nota es: $nota")
        }
    }
}

fun holaMundo(mensaje:String):Unit{
    println("Mensaje: $mensaje")
}


fun holaMundoAvanzado(mensaje:Any):Unit{
    println("Mensaje: $mensaje")
}
fun sumarDosnUmeros(numUno: Int, numDos:Int): Int{
    return numUno + numDos
}
