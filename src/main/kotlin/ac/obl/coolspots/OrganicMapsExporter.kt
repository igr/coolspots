package ac.obl.coolspots

import ac.obl.coolspots.db.DestinationSpots
import ac.obl.coolspots.db.Destinations
import ac.obl.coolspots.db.Recommendations
import ac.obl.coolspots.db.Spots
import ac.obl.coolspots.db.loadCoolSpotsDatabases
import ac.obl.coolspots.omaps.KmlDocument
import ac.obl.coolspots.omaps.KmlPlacemark
import java.io.File

fun main() {
    loadCoolSpotsDatabases()

    Destinations
        .map { Spots.of(it) }
        .map { createKmlDocument(it) }
        .forEach {
            val fileName = "CoolSpots ${it.destination.name}.kml"
            println(fileName)
            File("out/$fileName").writeText(it.get())
        }
}

private fun createKmlDocument(destinationSpots: DestinationSpots): KmlDocument {
    return destinationSpots
        .spots
        .map { Recommendations.of(it) }
        .map { KmlPlacemark(it) }
        .toList()
        .let { KmlDocument(destinationSpots.destination, it) }
}
