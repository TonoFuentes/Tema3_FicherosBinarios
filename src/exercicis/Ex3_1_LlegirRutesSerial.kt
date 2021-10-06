package exercicis

import java.io.DataInputStream
import java.io.FileInputStream

fun main() {
    val fichero = DataInputStream(FileInputStream("Rutes.dat"))
    var rutas: Int

    while (fichero.available() > 0) {
        println("Ruta: ${fichero.readUTF()}")
        println("Desnivell: ${fichero.readInt()}")
        println("Desnivell acumulat: ${fichero.readInt()}")
        rutas = fichero.readInt()
        println("Te $rutas punts")
        for (r in 1..rutas){
            print("Punt $r: ${fichero.readUTF()} (${fichero.readDouble()}, ${fichero.readDouble()})")
            println()
        }
        println()
    }
    fichero.close()
}