package fzgMaker

import javafx.application.Application
import tornadofx.*

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}

class MyApp : App(MyView::class)

