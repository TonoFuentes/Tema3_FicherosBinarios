package exercicis

import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Element
import java.io.FileWriter
import javax.xml.parsers.DocumentBuilderFactory

fun main() {
    //Declaracion variables para obtener datos del fichero XML
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("coches.xml")
    val arrelXml = doc.getDocumentElement()
    val llista = arrelXml.getElementsByTagName("vehiculo")

    //Declaracion Variables JSON
    val raiz = JSONObject()
    val oferta = JSONObject()
    raiz.put("Oferta", oferta)
    val vehiculo = JSONArray()
    oferta.put("Vehiculo", vehiculo)

    for (cont in 0 until llista.length){
        val coche = JSONObject()
        val cocheXml = llista.item(cont) as Element
        coche.put("Marca", cocheXml.getElementsByTagName("marca").item(cont).getTextContent())
        val modelo = JSONObject()
        modelo.put("color", cocheXml.getElementsByTagName("modelo").item(cont).getAttributes())
        modelo.put("Nombre_Modelo", cocheXml.getElementsByTagName("modelo").item(cont).getTextContent())
        coche.put("modelo", modelo)
        val motor = JSONObject()
        motor.put("Combustible", cocheXml.getElementsByTagName("motor").item(cont).getAttributes())
        motor.put("Nombre_Modelo", cocheXml.getElementsByTagName("motor").item(cont).getTextContent())
        coche.put("Motor", motor)
        coche.put("Matricula", cocheXml.getElementsByTagName("matricula").item(cont).getTextContent())
        coche.put("kilometros", cocheXml.getElementsByTagName("kilometros").item(cont).getTextContent())
        coche.put("Precio_Inicial", cocheXml.getElementsByTagName("precio_inicial").item(cont).getTextContent())
        coche.put("Precio_Oferta", cocheXml.getElementsByTagName("precio_oferta").item(cont).getTextContent())
        val extra = JSONArray()
        coche.put("Extra", extra)
        val extraContenido1 = JSONObject()
        extraContenido1.put("Valor", cocheXml.getElementsByTagName("extra").item(cont).getAttributes())
        extraContenido1.put("Nombre_Extra", cocheXml.getElementsByTagName("extra").item(cont).getTextContent())
        val extraContenido2 = JSONObject()
        extraContenido2.put("Valor", cocheXml.getElementsByTagName("extra").item(cont+1).getAttributes())
        extraContenido2.put("Nombre_Extra", cocheXml.getElementsByTagName("extra").item(cont+1).getTextContent())
        extra.put(extraContenido1)
        extra.put(extraContenido2)
        val foto = JSONArray()
        foto.put(cocheXml.getElementsByTagName("foto").item(cont).getTextContent())
        foto.put(cocheXml.getElementsByTagName("foto").item(cont+1).getTextContent())
        coche.put("Foto", foto)
        vehiculo.put(coche)
    }

    val f = FileWriter("Coche.json")
    f.write(raiz.toString(4))
    f.close()
}