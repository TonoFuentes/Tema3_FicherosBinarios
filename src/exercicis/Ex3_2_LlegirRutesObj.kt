package exercicis

import exemples.Empleat
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main() {
    val f = ObjectInputStream(FileInputStream("Rutes.obj"))

    try {
        while (true) {
            val fichero = f.readObject() as Ruta
            fichero.mostrarRuta()
        }
    } catch (eof: EOFException) {
        f.close()
    }
}