package View

import Controller.RdWrFiles
import Model.Client
import java.awt.*
import java.awt.event.ActionListener
import java.awt.image.ColorModel
import javax.swing.*

class AnadirClientView (){
    var panelAnadirView = JPanel()
    var idLabel = JLabel()
    var nameLabel = JLabel()
    var apellidoLabel = JLabel()
    var correoLabel = JLabel()
    var generoLabel = JLabel()
    var idTextField = JTextField("",20)
    var nameTextField = JTextField(20)
    var apellidoTextField = JTextField(20)
    var correoTextField = JTextField(20)
    var generoTextField = JTextField(20)
    val frame = JFrame("Añadir Cliente")
    val anadirButton = JButton()

    init{
        idLabel.text = "ID:"
        nameLabel.text = "Nombre:"
        apellidoLabel.text = "Apellido:"
        correoLabel.text = "Correo:"
        generoLabel.text = "Genero:"
        anadirButton.text = "Añadir"
        anadirButton.font = Font("Comic Sans MS", Font.BOLD, 12)
        anadirButton!!.addActionListener(ActionListener {
            val str = idTextField.text + ","+nameTextField.text +","+ apellidoTextField.text+","+ correoTextField.text +","+generoTextField.text

            RdWrFiles.writeFile("src/Database/Clientes",str)
            val mv = Client(
                idTextField.text,
                nameTextField.text,
                apellidoTextField.text,
                correoTextField.text ,
                generoTextField.text
            )
            Client.clientsList!!.add(mv)
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
        frame.add(apellidoLabel,con)
        con.gridx =1
        con.gridy=2
        frame.add(apellidoTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=3
        frame.add(correoLabel,con)
        con.gridx =1
        con.gridy=3
        frame.add(correoTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=4
        frame.add(generoLabel,con)
        con.gridx =1
        con.gridy=4
        frame.add(generoTextField,con)
        con.fill = GridBagConstraints.HORIZONTAL
        con.gridx =0
        con.gridy=5
        con.gridwidth = 2;
        frame.add(anadirButton,con)


        frame.setLocationRelativeTo(null)
        frame.isVisible = true
        //frame.setResizable(false)

    }
}