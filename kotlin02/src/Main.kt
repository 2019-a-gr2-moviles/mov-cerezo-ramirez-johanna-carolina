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

// clase 5 a partir de aqui


class Usuario(val cedula:String){
    //Propiedades
    //Se las debe inicializar
    public var nombre:String = ""
    public var apellido:String = ""

    constructor(cedulaM:String,
                apellido:String): this(cedulaM)  {
        this.apellido = apellido
    }



}
//Este es el principal tipo de constructor
class UsuarioKT(public var nombre:String,
                public var apellido:String,
                private var id:Int,
                protected var id_:Int){

    //Public y unit son por defecto para las funciones
    public fun hol():String{
        return this.apellido
    }
    //Clases estaticas: cuando no se necestia instanciar una clase para utilizar los metodos o propiedades que tiene
    // Se crean dentro de un companion object:

    companion object {
        val gravedad = 10.5
        fun correr(){
            println("estoy correindo en $gravedad")
        }
    }

}

//Ejemplo clase Estatica:
class BaseDeDatos{
    companion object {
        val usuarios = arrayListOf(1,2,3)
        fun agregarUsuarios(usuario:Int){
            this.usuarios.add(usuario)
        }
    }
}

//Singelton = una unica extansia de una clase: se puede usar un companion object para almacenar ese singleton

fun a(){
    val adrian = UsuarioKT("a",  "b" , 111,111)
    adrian.nombre = "aaaaasas"
    //Set y gets ya estan creados previamente y solo se los usa no hay que crearlos
    // Por defecto todas la propiedades en kotlin son publicas
    //En los proyectos usar una clase base de datos con companion object par tener las funciones de eliminano,agregar, etc.
    //Y se la puede extender a las otras clases oara
}

//Se puede tener varios constructores, estos existen para la sobrecarga de metodos: ac contiuacion un ejemplo
class Numero(var numero:Int){
    constructor(numeroString:String):this(numeroString.toInt()){
        println("const")
        //Se imprime segundo
    }
    init{
        println("init")
        //Se imprime primero
    }
}

//Tambien existe para crear construntores con mas tipos de paramentros
//Init pertenece al primer constructoe, es el bloque de codigo del primer constructor



//Una calse abstracta es aquella que no se la instancia

abstract class Numeros (var numeroUno:Int, var numeroDos: Int){

}

class Suma( numeroUnoss:Int,
            numeroDoss:Int):Numeros(numeroUnoss,numeroDoss){

}
//Si solo se necestia parametros no se pone la palabra var o val, esto se usa para utilizar cuando se va a llenar la propiedades del padre
fun cc(){
    val a = Suma(1,2)
}


//Todas las clases en Kotlin son final
//Se usa open cuando se le quiere quitar lo final a una clase para que luego esta clase se pueda heredar
//Abstract se usa para cuando no se quiere instanciar esa clase


//
fun presley(requerido:Int,
            opcional:Int = 1,
            nulo:UsuarioKT?){
    if(nulo != null){
        nulo.nombre
    }
    val nombresito = nulo?.nombre.toString()
    nulo!!.nombre //Este sirve como el If de mas arriba pero asegurandole al compilador que la variable no va a ser null nunca

    //Int? siginfica que esta variable a veces va a ser nulo
    // Y sirve para cualquier clase dentro de kotlin incluso las creadas por uno mismo


}

fun cddd(){
    //named parameters:
    presley(requerido=1, nulo = null)
    presley(1,1,null)
    presley(1, 1, null)

}




