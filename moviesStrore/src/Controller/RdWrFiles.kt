package Controller

import java.io.File


 class RdWrFiles{
    companion object {

        var file = File("src/Database/Movies")

        fun readFile(filename: String): List<String> = File(filename).readLines()

        fun printFileLines(lines: List<String>) {
            lines.forEach { println(it) }
        }

        fun writeFile(fileName: String, textToBeAppended: String) {
           File(fileName).appendText(textToBeAppended + "\n")
        }


        fun exists(id: Int): Boolean {

            var itExists = false
            file.forEachLine {
                val bill = it.split(",")
                if (bill[0] == id.toString()) {
                    itExists = true
                }
            }
            return itExists
        }

        fun delete(id: Int): Boolean {
            if (!exists(id)) {
                return false
            } else {
                var deleteHandler: ArrayList<String> = ArrayList()
                file.forEachLine {
                    val bill = it.split(",")
                    if (bill[0] != id.toString()) {
                        deleteHandler.add(it)
                    }
                }
                file.writeText("")
                deleteHandler.forEach {
                    file.appendText(it+"\n")
                }
                return true
            }
        }


    }
}