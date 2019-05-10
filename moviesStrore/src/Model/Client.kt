package Model

import Controller.RdWrFiles

class Client (val id: String,
              var name:String,
              var apellido:String,
              var correo: String,
              var gender:String) {

    init {


    }


    fun propertiesStr(): String {
        val str = this.id+","+this.name+","+this.apellido+","+this.correo+","+this.gender
        return str

    }

    companion object{
        fun propertiesNames(): Array<String> {
            val columnNames = arrayOf("Id","Nombre","Apellido","Correo","Genero")
            return columnNames
        }
        var clientsList: ArrayList<Client>? = ArrayList()

        fun createFromDB(){
            val aux: ArrayList<Client>? = ArrayList()
            val lines = RdWrFiles.readFile("src/Database/Clientes")
            lines.forEach{
                val property= it.split(",")
                val client =  Client(property[0],property[1],property[2],property[3],property[4])
                aux!!.add(client)
            }
            clientsList = aux

        }

        fun getClientsAtributtes(): ArrayList<String>? {
            var attributesClientsList : ArrayList<String>? = ArrayList()
            clientsList!!.forEach {it
                attributesClientsList!!.add(it.propertiesStr())
            }

            return attributesClientsList

        }
    }

    fun saveToDB(){
        print(propertiesStr())
        RdWrFiles.writeFile("src/Database/Clientes",propertiesStr())

    }



}