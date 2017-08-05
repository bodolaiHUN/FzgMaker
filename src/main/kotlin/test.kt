package fzgMaker

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


fun ModifyXmlFileDemo() {

    try {
        val inputFile = File("/home/bodoo/Kotlin/FzgMakerGit/input.xml")
        val docFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = docFactory.newDocumentBuilder()
        val doc = docBuilder.parse(inputFile)
        val cars = doc.firstChild
        val supercar = doc.getElementsByTagName("supercars").item(0)
        // update supercar attribute
        val attr = supercar.attributes
        val nodeAttr = attr.getNamedItem("company")
        nodeAttr.textContent = "Lamborigini"

        // loop the supercar child node
        val list = supercar.childNodes
        for (temp in 0..list.length - 1) {
            val node = list.item(temp)
            if (node.nodeType == Node.ELEMENT_NODE) {
                val eElement = node as Element
                if ("carname" == eElement.nodeName) {
                    if ("Ferrari 101" == eElement.textContent) {
                        eElement.textContent = "Lamborigini 001"
                    }
                    if ("Ferrari 202" == eElement.textContent)
                        eElement.textContent = "Lamborigini 002"
                }
            }
        }

        val transformerFactory = TransformerFactory.newInstance()
        val transformer = transformerFactory.newTransformer()
        val source = DOMSource(doc)
        println("-----------Modified File-----------")
        val consoleResult = StreamResult(System.out)
        transformer.transform(source, consoleResult)
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun main(argv: Array<String>) {
    ModifyXmlFileDemo()
}