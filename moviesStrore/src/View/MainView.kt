package View

import java.awt.Font
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import java.awt.event.ActionListener
import javax.swing.*

public class MainView(){
    var panelAnadirView = JPanel()
    var moviesLabel = JLabel()
    var imgLabel = JLabel()

    val frame = JFrame("Inicio")

    val inicioButton = JButton()
    val clientsButton = JButton()

    init{
        moviesLabel.text = "Películas"
        moviesLabel.font = Font("Comic Sans MS", Font.PLAIN, 20)
        inicioButton.text = "Inicio"
        inicioButton.font = Font("Comic Sans MS", Font.BOLD, 12)
        clientsButton.text = "Ver Clientes"
        clientsButton.font = Font("Comic Sans MS", Font.BOLD, 12)

        inicioButton!!.addActionListener(ActionListener {
            val pr = UserView()
            pr.main()
            frame.dispose()
        })

        clientsButton!!.addActionListener(ActionListener {
            val pr = ClientView()
            pr.main()
            frame.dispose()
        })
        frame.setSize(500,400)
        frame.contentPane = panelAnadirView
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        val image = ImageIcon("src/Database/cinema-2-512.png")
        imgLabel.icon = image
        imgLabel.text = ""
        var ly = GridBagLayout()
        var con = GridBagConstraints()
        con.insets = Insets(3,3,3,3)
        frame.contentPane.setLayout(ly)

        con.fill = GridBagConstraints.CENTER
        con.gridx =0
        con.gridy=0
        frame.add(moviesLabel,con)
        con.fill = GridBagConstraints.CENTER
        con.gridx =0
        con.gridy=1
        frame.add(imgLabel,con)
        con.gridx =0
        con.gridy=2
        con.gridwidth = 2;
        frame.add(inicioButton,con)
        con.gridx =0
        con.gridy=3
        con.gridwidth = 2;
        frame.add(clientsButton,con)


        frame.setLocationRelativeTo(null)
        frame.isVisible = true
        //frame.setResizable(false)

    }

    fun main(){
        frame.isVisible= true
    }


}