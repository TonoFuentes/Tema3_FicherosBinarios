package exercicis

import com.squareup.moshi.*
import java.io.EOFException
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main (args: Array<String>){
    val f = ObjectInputStream(FileInputStream("Rutes.obj"))
    val rutas = ArrayList<Ruta>()

    try {
        while (true) {
            val fichero = f.readObject() as Ruta
            rutas.add(Ruta(fichero.nom,fichero.desnivell,fichero.desnivellAcumulat,fichero.llistaDePunts))
        }
    } catch (eof: EOFException) {
        f.close()
    }

    val rutes = Rutes(rutas)

    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Rutes::class.java)
    val json = adapter.toJson(rutes)

    File("Rutes.json").writeText(json)
}

class Rutes(var rutes: MutableList<Ruta> = mutableListOf<Ruta>())