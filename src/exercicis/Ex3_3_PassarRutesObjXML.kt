package exercicis

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main() {
    val f = ObjectInputStream(FileInputStream ("Rutes.obj"))

    val doc = DocumentBuilderFactory.newInstance ().newDocumentBuilder().newDocument()
    val arrel = doc.createElement ("Rutes")
    doc.appendChild(arrel)

    try {
        while (true) {
            val r = f.readObject() as Ruta
            val ruta = doc.createElement("Ruta")

            val nom = doc.createElement("Nom")
            nom.setTextContent(r.nom)
            ruta.appendChild(nom)

            val desnivell = doc.createElement("Desnivell")
            desnivell.setTextContent(r.desnivell.toString())
            ruta.appendChild(desnivell)

            val desnivellAcum = doc.createElement("DesnivellAcumulat")
            desnivellAcum.setTextContent(r.desnivellAcumulat.toString())
            ruta.appendChild(desnivellAcum)

            val punts = doc.createElement("Punts")
            ruta.appendChild(punts)

            var contador = 1
            for (punt in r.llistaDePunts){
                val punto = doc.createElement("Punt")
                punto.setAttribute("num", contador.toString())
                punts.appendChild(punto)

                val nom = doc.createElement("Nom")
                nom.setTextContent(punt.nom)
                punto.appendChild(nom)

                val latitud = doc.createElement("Latitud")
                latitud.setTextContent(punt.coord.latitud.toString())
                punto.appendChild(latitud)

                val longitud = doc.createElement("Longitud")
                longitud.setTextContent(punt.coord.longitud.toString())
                punto.appendChild(longitud)

                contador++
            }
            contador = 1

            arrel.appendChild(ruta)
        }
    } catch (eof: EOFException) {
        f.close()
    }
    val trans = TransformerFactory.newInstance().newTransformer()

    trans.transform(DOMSource(doc), StreamResult("Rutes.xml"))
}