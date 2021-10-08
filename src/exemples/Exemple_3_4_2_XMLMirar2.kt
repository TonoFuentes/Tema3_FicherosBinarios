package exemples

import javax.xml.parsers.DocumentBuilderFactory

fun main(args: Array<String>) {
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("coches.xml")
    val arrel = doc.documentElement   // apuntarà a l'element arrel
    val fills = arrel.childNodes
    println(fills.item(0).nodeName)   // el primer fill és el retorn de carro; ens dirà que és de text
    println(fills.item(1).nodeName)   // el segon fill sí que és vehiculo
    println(fills.item(2).nodeName)   // el tercer fill és el retorn de carro; ens dirà que és de text
    println(fills.item(3).nodeName)   // el quart fill sí que és vehiculo
    println(fills.item(4).nodeName)   // el cinquè fill és el retorn de carro; ens dirà que és de text
    println(fills.item(5).nodeName)   // no existeix el sisè fill. Donarà error
}