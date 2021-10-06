package exercicis

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main() {
    val f = ObjectOutputStream(FileOutputStream("Rutes.obj"))
    val fichero = DataInputStream(FileInputStream("Rutes.dat"))

    while (fichero.available() > 0) {
        val nombre = fichero.readUTF()
        val desnivell = fichero.readInt()
        val desnivellAcum = fichero.readInt()
        val rutasTotal = fichero.readInt()
        var listaRutas: MutableList<PuntGeo> = ArrayList()
        for (r in 0..rutasTotal) {
            val nom = fichero.readUTF()
            val coord: Coordenades = Coordenades(fichero.readDouble(),fichero.readDouble())
            listaRutas.add(PuntGeo(nom,coord))
        }
        val ruta = Ruta(nombre,desnivell,desnivellAcum,listaRutas)
        f.writeObject(ruta)
    }

    f.close()
    fichero.close()
}