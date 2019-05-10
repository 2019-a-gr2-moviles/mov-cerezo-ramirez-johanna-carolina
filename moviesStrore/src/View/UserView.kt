package View

import Controller.RdWrFiles
import Model.Movie
import javax.swing.*
import javax.swing.table.DefaultTableModel
import javax.swing.JFrame
import java.awt.event.ActionListener
import javax.swing.JTable
import javax.swing.GroupLayout
import java.awt.Font




class UserView  {

    val cancelButton: JButton? = JButton()
    val deleteButton: JButton? = JButton()
    val addButton: JButton? = JButton()
    val updateButton: JButton? = JButton()
    var panelUserView: JPanel? = JPanel()
    private val spanel: JScrollPane? = JScrollPane()
    companion object{
        val frame = JFrame("Lista de Peliculas")
        var tableMovies: JTable? = JTable()
    }



    init{

        frame.contentPane = panelUserView
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(600,600)

        var ly = GroupLayout(frame.contentPane)
        frame.contentPane.setLayout(ly)
        ly.autoCreateGaps = true
        ly.autoCreateContainerGaps = true
        spanel!!.add(tableMovies)
        var label = createLabel()

        createButtons()
        ly.setVerticalGroup(ly.createSequentialGroup()
            .addGroup(ly.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(label)
                )
            .addComponent(spanel)
            .addGroup(ly.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(deleteButton)
                .addComponent(addButton)
                .addComponent(updateButton)
                .addComponent(cancelButton)
                )
        )

        ly.setHorizontalGroup(ly.createSequentialGroup()
            .addGroup(ly.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(label)
                .addComponent(spanel)
                .addGroup(ly.createSequentialGroup()
                    .addGroup(ly.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addComponent(deleteButton)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(cancelButton)
                    )))


        frame.setLocationRelativeTo(null)
        frame.isVisible = true
        //frame.setResizable(false)

    }

    fun main(){
        fillTable(Movie.propertiesNames(),"src/Database/Movies")

    }

    fun fillTable(columnNames: Array<String>,path:String) {
        Movie.createFromDB()
        var datos: List<String> = Movie.getMoviesAtributtes()!!.toList()
        val size = datos.size
        val sizeColumn = columnNames.size
        val datosObj = convertFromArrayToArrayOfArrays(datos,size,sizeColumn)
        val model = DefaultTableModel(datosObj, columnNames)
        tableMovies = JTable(model)
        spanel!!.viewport.add(tableMovies)
    }

    fun addRowToTable( columnNames: Array<String>, path: String,info:Array<String>) {
        var datos: List<String> = RdWrFiles.readFile(path)
        val size = datos.size
        val sizeColumn = columnNames.size
        val datosObj = convertFromArrayToArrayOfArrays(datos,size,sizeColumn)
        val model = DefaultTableModel(datosObj, columnNames)
        tableMovies = JTable(model)
        model.addRow(arrayOf(info))

    }

    fun convertFromArrayToArrayOfArrays(datos: List<String>, size:Int, sizeColumn:Int): Array<Array<Any>> {
        val datosObj = Array<Array<Any>>(size) { (arrayOf(sizeColumn)) }

        datos.forEachIndexed{ index, line ->
            var ln = line.split(",")
            datosObj.set(index, ln.toTypedArray())
        }
        return datosObj
    }

     fun createButtons() {

        cancelButton!!.text = "Cancel"
         cancelButton!!.font = Font("Comic Sans MS", Font.BOLD, 12)
         cancelButton!!.addActionListener(ActionListener {
             System.exit(0)
         })

        deleteButton!!.text = "Borrar"
         deleteButton!!.font = Font("Comic Sans MS", Font.BOLD, 12)
         deleteButton!!.addActionListener(ActionListener {
             removeSelectedRows(tableMovies!!)
         })

         addButton!!.text = "Añadir"
         addButton!!.font = Font("Comic Sans MS", Font.BOLD, 12)
         addButton!!.addActionListener(ActionListener {
             AnadirUserView()
         })
         updateButton!!.text = "Actualizar"
         updateButton!!.font = Font("Comic Sans MS", Font.BOLD, 12)
         updateButton!!.addActionListener(ActionListener {
             fillTable(Movie.propertiesNames(),"src/Database/Movies")
         })

    }

    fun createLabel(): JLabel {
        var supJLabel = JLabel()
        supJLabel.font = Font("Comic Sans MS", Font.PLAIN, 28)
        supJLabel.text = "LISTA DE PELICULAS"

        return supJLabel
    }


    fun removeSelectedRows(table: JTable) {
        val model = table.getModel() as DefaultTableModel
        val rows = table.selectedRows
        val numRows = table.selectedRows.size
        val str = table.selectedRow.toString()
        val idToRemove = table.getValueAt(table.selectedRow,0).toString()
        println(idToRemove)
        for (i in 0 until numRows) {
            model.removeRow(table.selectedRow)
        }
        RdWrFiles.delete(idToRemove.toInt())
        Movie.moviesList!!.forEach {
            if(it.id == idToRemove) {
                println(it.name)
                Movie.moviesList!!.remove(it)
            }
        }



    }

}


//Entregar dos proyectos uno individual y otro en grpo
//Se debe poder abrirlas aplicaciones del telefono y usar apis extarnas de azure y de google