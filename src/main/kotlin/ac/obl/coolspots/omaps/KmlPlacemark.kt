package ac.obl.coolspots.omaps

import ac.obl.coolspots.db.Category
import ac.obl.coolspots.db.SpotRecommendations

class KmlPlacemark(spotRecommendations: SpotRecommendations) {

    private val spot = spotRecommendations.spot
    private val name = spot.name
    private val description = descriptionOf(spotRecommendations)

    private fun descriptionOf(spotRecommendations: SpotRecommendations): Any {
        val spot = spotRecommendations.spot
        val recommendations = spotRecommendations.recommendations
        return spot.address + "\n\n" + recommendations.joinToString(separator = "\n\n") { it.description }
    }

    private val color = when (spot.category) {
        Category.ACCOMMODATION -> "blue"
        Category.ACTIVITIES -> "red"
        Category.COFFEE -> "brown"
        Category.CULTURE -> "red"
        Category.FOOD -> "deeporange"
        Category.NIGHT -> "deeppurple"
        Category.OUTDOOR -> "green"
        Category.SHOP -> "yellow"
        Category.OTHER -> "gray"
    }
    private val lat = spot.location.lat.toString()
    private val lon = spot.location.lon.toString()

    private val featureType = when (spot.category) {
        Category.ACCOMMODATION -> "tourism-hotel"
        Category.ACTIVITIES -> "sport"
        Category.COFFEE -> "amenity-cafe"
        Category.CULTURE -> "tourism-attraction"
        Category.FOOD -> "amenity-restaurant"
        Category.NIGHT -> "nightlife"
        Category.OUTDOOR -> "leisure-park"
        Category.SHOP -> "shopping"
        Category.OTHER -> ""
    }
    private val icon = when (spot.category) {
        Category.ACCOMMODATION -> "Hotel"
        Category.ACTIVITIES -> "Entertainment"
        Category.COFFEE -> "Food"
        Category.CULTURE -> "Museum"
        Category.FOOD -> "Food"
        Category.NIGHT -> "Entertainment"
        Category.OUTDOOR -> "Sights"
        Category.SHOP -> "None"
        Category.OTHER -> "None"
    }


    fun get() = """
<Placemark>
    <name><![CDATA[${name}]]></name>
    <description><![CDATA[${description}]]></description>
    <styleUrl>#placemark-${color}</styleUrl>
    <Point><coordinates>${lon},${lat}</coordinates></Point>
    <ExtendedData xmlns:mwm="https://omaps.app">
      <mwm:name>
        <mwm:lang code="default"><![CDATA[${name}]]></mwm:lang>
      </mwm:name>
      <mwm:description>
        <mwm:lang code="default"><![CDATA[${description}]]></mwm:lang>
      </mwm:description>
      <mwm:featureTypes>
        <mwm:value>${featureType}</mwm:value>
      </mwm:featureTypes>
      <mwm:scale>19</mwm:scale>
      <mwm:icon>${icon}</mwm:icon>
      <mwm:visibility>1</mwm:visibility>
    </ExtendedData>
  </Placemark>    
""".trimIndent()

}
