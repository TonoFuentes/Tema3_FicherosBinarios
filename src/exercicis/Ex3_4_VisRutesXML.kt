package exercicis

import javax.swing.*
import java.awt.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory


class Finestra : JFrame() {

    init {
        var doc: Document
        // sentències per a omplir doc

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1,BorderLayout.NORTH)
        add(panell2,BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutes.xml")
        val arrel = doc.getDocumentElement()
        val llista = arrel.getElementsByTagName("Ruta")

        for (i in 0 until llista.getLength()){
            val el = llista.item(i) as Element
            llistaRutes.add(el.getElementsByTagName("Nom").item(0).getTextContent())
        }

        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"),BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener{
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            val r = llista.item(combo.selectedIndex) as Element
            area.text = ""

            for (cont in 0 until llista.length) {
                val el = llista.item(cont) as Element
                val puntos = el.getElementsByTagName("Punt")

                if(((combo.selectedIndex) == cont)) {
                    for (contador in 0 until puntos.length)
                        area.append(el.getElementsByTagName("Nom").item(contador+1).getTextContent() + " (" + el.getElementsByTagName("Latitud").item(contador).getTextContent() + ", " + el.getElementsByTagName("Longitud").item(contador).getTextContent() + ")\n")
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        Finestra().isVisible = true
    }
}