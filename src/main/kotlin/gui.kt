package fzgMaker

import javafx.scene.control.TextField
import javafx.scene.control.ToggleGroup
import javafx.stage.FileChooser
import tornadofx.*

class MyView : View() {

    var daisyField: TextField by singleAssign()
    private val toggleGroup = ToggleGroup()
    private val fileinput = FileInput()
    private val fileoutput = FileOutput()
    private val fileChooserOpen = FileChooser()
    private val fileChooserSave = FileChooser()
    val type = Type()
    val daisy = Daisy()

    override val root = vbox {
        hbox {
            label("Daisy:")
            daisyField = textfield()
        }

        radiobutton("TT", toggleGroup) {
            action { type.name = "TT" }
        }
        radiobutton("A3", toggleGroup) {
            action { type.name = "A3" }
        }
        radiobutton("A4", toggleGroup) {
            action { type.name = "A4" }
        }
        radiobutton("Q3", toggleGroup) {
            action { type.name = "Q3" }
        }
        radiobutton("Q5", toggleGroup) {
            action { type.name = "Q5" }
        }

        fileChooserOpen.extensionFilters.addAll(FileChooser.ExtensionFilter("PrNr", "*.txt"))
        fileChooserOpen.title = "PR számok:"

        button("PR számok") {
            setOnAction {
                val selectedFile = fileChooserOpen.showOpenDialog(primaryStage)
                if (selectedFile != null) {
                    fileinput.name = selectedFile.absolutePath
                    println(fileinput.name)
                    println(type.name)
                }
            }

        }

        //*TODO lehessen csak mappát választani, a fájl neve a daisy + '.fzg"*//
        fileChooserSave.title = "FZG mentése:"

        button("Válassz mappát") {
            setOnAction {
                val selectedFile = fileChooserOpen.showSaveDialog(primaryStage)
                if (selectedFile != null) {
                    fileoutput.name = selectedFile.absolutePath
                    println(fileoutput.name)
                    daisy.name = daisyField.text
                    println(daisy.name)
                }
            }

        }

    }
}



