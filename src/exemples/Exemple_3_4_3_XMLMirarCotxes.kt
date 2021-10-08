package exemples

import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Element

fun main(args: Array<String>) {
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("coches.xml")
    val arrel = doc.documentElement  // apuntarà a l'element arrel
    val llista = arrel.getElementsByTagName("vehiculo")

    for (i in 0 until llista.length) {
        val el = llista.item(i) as Element
        println(el.nodeName + " " + (i + 1))
        println("Marca: " + el.getElementsByTagName("marca").item(0).childNodes.item(0).nodeValue)
        println("Matrícula: " + el.getElementsByTagName("matricula").item(0).firstChild.nodeValue)
        println("Motor: " + el.getElementsByTagName("motor").item(0).textContent)
        println("Combustible: " + el.getElementsByTagName("motor").item(0).attributes.item(0).nodeValue)
        val m = el . getElementsByTagName ("motor").item(0) as Element
        println("Combustible: " + m.getAttribute("combustible"))
        println()
    }
    println(arrel.textContent)
}