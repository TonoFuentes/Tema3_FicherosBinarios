package exemples

import javax.xml.parsers.DocumentBuilderFactory

fun main(args: Array<String>){
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("coches.xml")
    println(doc.nodeName)     	    // torna el nom del document. No és l'element arrel. Ens dirà #document
    val arrel = doc.documentElement // apuntarà a l'element arrel
    println(arrel.nodeName)			// torna el nom de l'element. Ens dirà oferta
    println(arrel.nodeValue)		// torna el valor de l'element. Com és un element que conté altres elements, el valor és null
}