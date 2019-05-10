package View

import Controller.RdWrFiles
import Model.Movie
import java.awt.Font
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import java.awt.event.ActionListener
import javax.swing.*

class AnadirUserView {
    var panelAnadirView = JPanel()
    var idLabel = JLabel()
    var nameLabel = JLabel()
    var dateLabel = JLabel()
    var directorLabel = JLabel()
    var precioLabel = JLabel()
    var generoLabel = JLabel()
    var idTextField = JTextField("",20)
    var nameTextField = JTextField(20)
    var dateTextField = JTextField(20)
    var directorTextField = JTextField(20)
    var precioTextField = JTextField(20)
    var generoTextField = JTextField(20)
    val frame = JFrame("Añadir Pelicula")
    val anadirButton = JButton()

    init{
        idLabel.text = "ID:"
        nameLabel.text = "Nombre:"
        dateLabel.text = "Fecha:"
        directorLabel.text = "Director:"
        precioLabel.text = "Precio:"
        generoLabel.text = "Genero:"
        anadirButton.text = "Añadir"
        anadirButton.font = Font("Comic Sans MS", Font.BOLD, 12)
        anadirButton!!.addActionListener(ActionListener {
            val str = idTextField.text + ","+nameTextField.text +","+ dateTextField.text+","+ directorTextField.text +","+precioTextField.text+","+generoTextField.text

            RdWrFiles.writeFile("src/Database/Movies",str)
            val mv = Movie(
                idTextField.text,
                nameTextField.text,
                dateTextField.text,
                directorTextField.text ,
                precioTextField.text,
                generoTextField.text
            )
            Movie.moviesList!!.add(mv)
            frame.dispose()

        })
        frame.setSize(400,300)
        frame.contentPane = panelAnadirView
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE


        var ly = GridBagLayout()
        var con = GridBagConstraints()
        con.insets = Insets(3,3,3,3)
        frame.contentPane.setLayout(ly)

        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=0
        frame.add(idLabel,con)
        con.gridx =1
        con.gridy=0
        frame.add(idTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=1
        frame.add(nameLabel,con)
        con.gridx =1
        con.gridy=1
        frame.add(nameTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
                con.gridx =0
        con.gridy=2
        frame.add(dateLabel,con)
        con.gridx =1
        con.gridy=2
        frame.add(dateTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=3
        frame.add(directorLabel,con)
        con.gridx =1
        con.gridy=3
        frame.add(directorTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=4
        frame.add(precioLabel,con)
        con.gridx =1
        con.gridy=4
        frame.add(precioTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=5
        frame.add(generoLabel,con)
        con.gridx =1
        con.gridy=5
        frame.add(generoTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=6
        con.gridwidth = 2;
        frame.add(anadirButton,con)


        frame.setLocationRelativeTo(null)
        frame.isVisible = true
        //frame.setResizable(false)

    }

/*    fun main(){
        frame.isVisible= true
    }
    */




}