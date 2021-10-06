package exercicis

import java.io.Serializable

class PuntGeo(nom: String, coord: Coordenades): Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    var nom: String
    var coord: Coordenades

    init {
        this.nom = nom
        this.coord = coord
    }
}