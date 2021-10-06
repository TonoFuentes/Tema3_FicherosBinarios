package exercicis

import java.io.Serializable

class Coordenades(latitud: Double, longitud: Double): Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
    var latitud: Double = 0.0
    var longitud: Double = 0.0
}