import java.awt.BorderLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class gui : JPanel(BorderLayout()), ActionListener {
    init {
        val radioButtonTT = JRadioButton(typeTT)
        radioButtonTT.actionCommand = typeTT
        val radioButtonA3 = JRadioButton(typeA3)
        radioButtonA3.actionCommand = typeA3
        val radioButtonA4 = JRadioButton(typeA4)
        radioButtonA4.actionCommand = typeA4
        val radioButtonQ3 = JRadioButton(typeQ3)
        radioButtonQ3.actionCommand = typeQ3
        val radioButtonQ5 = JRadioButton(typeQ5)
        radioButtonQ5.actionCommand = typeQ5
        var buttonPrNr = JButton("PrNr:")
        buttonPrNr.actionCommand = pRnR
        var buttonMentes = JButton("Mentés")
        buttonMentes.actionCommand = mentes


        val group = ButtonGroup()
        group.add(radioButtonTT)
        group.add(radioButtonA3)
        group.add(radioButtonA4)
        group.add(radioButtonQ3)
        group.add(radioButtonQ5)

        radioButtonTT.addActionListener(this)
        radioButtonA3.addActionListener(this)
        radioButtonA4.addActionListener(this)
        radioButtonQ3.addActionListener(this)
        radioButtonQ5.addActionListener(this)

        buttonPrNr.addActionListener(this)
        buttonMentes.addActionListener(this)

        //Put the radio buttons in a column in a panel.
        val radioPanel = JPanel(GridLayout(0, 1))
        radioPanel.add(radioButtonA3)
        radioPanel.add(radioButtonA4)
        radioPanel.add(radioButtonQ3)
        radioPanel.add(radioButtonQ5)
        radioPanel.add(radioButtonTT)
        radioPanel.add(buttonPrNr)
        radioPanel.add(buttonMentes)

        add(radioPanel, BorderLayout.LINE_START)
        border = BorderFactory.createEmptyBorder(20, 20, 20, 20)


    }

    companion object {
        internal var typeTT = "TT"
        internal var typeA3 = "A3"
        internal var typeA4 = "A4"
        internal var typeQ3 = "Q3"
        internal var typeQ5 = "Q5"
        internal var pRnR = "PrNr"
        internal var mentes = "Mentes"
    }


    /** Listens to the radio buttons.  */
    override fun actionPerformed(e: ActionEvent) {
        val type = e.actionCommand
        when (type) {
            typeA3, typeA4, typeQ3, typeQ5, typeTT -> println(type)
            pRnR -> openPrNr()
            mentes -> mentesFzg()
        }
    }

    fun openPrNr() {
        var fc = JFileChooser()
        fc.fileSelectionMode = JFileChooser.FILES_AND_DIRECTORIES
        val returnVal = fc.showOpenDialog(this@gui)

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            val file = fc.selectedFile
            //This is where a real application would open the file.
            println("Opening: " + file.name)
        } else {
            println("Open command cancelled by user.")
        }
    }

    fun mentesFzg() {
        var fc = JFileChooser()
        fc.fileSelectionMode = JFileChooser.FILES_AND_DIRECTORIES
        val returnVal = fc.showSaveDialog(this@gui)
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            val file = fc.selectedFile
            //This is where a real application would save the file.
            println("Saving: " + file.name + "." + "/n")
        } else {
            println("Save command cancelled by user." + "/n")
        }
    }


    fun createAndShowGUI() {
        //Create and set up the window.
        val frame = JFrame("FzgMaker")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        //Create and set up the content pane.
        val newContentPane = gui()
        newContentPane.isOpaque = true //content panes must be opaque
        frame.contentPane = newContentPane

        //Display the window.
        frame.pack()
        frame.isVisible = true
    }

}
