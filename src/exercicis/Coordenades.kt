package exercicis

import java.io.Serializable

class Coordenades(latitud: Double, longitud: Double): Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
    var latitud: Double
    var longitud: Double

    init {
        this.latitud = latitud
        this.longitud = longitud
    }
}