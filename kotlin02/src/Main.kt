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

