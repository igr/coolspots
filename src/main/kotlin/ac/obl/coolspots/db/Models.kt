package ac.obl.coolspots.db

enum class Sex {
    MALE,
    FEMALE
}

enum class Category {
    ACCOMMODATION,
    ACTIVITIES,
    COFFEE,
    CULTURE,
    FOOD,
    NIGHT,
    OTHER,
    OUTDOOR,
    SHOP,
}

data class LatLon(val lat: Double, val lon: Double) {
    constructor(lat: String, lon: String) : this(lat.toDouble(), lon.toDouble())
}

data class Destination(
    val name: String,
    val country: String,
    val countryName: String,
    val center: LatLon,
    val northEast: LatLon,
    val southWest: LatLon,
)

data class Spot(
    val destination: Destination,
    val name: String,
    val address: String,
    val location: LatLon,
    val category: Category,
    val type: String?,
    val phone: String?,
    val website: String?,
    val facebook: String?,
    val instagram: String?,
)

data class Cousin(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val sex: Sex,
    val about: String,
    val description: String,
    val welcomeMessage: String,
    val facebook: String?,
    val instagram: String?,
    val tumblr: String?,
    val twitter: String?,
    val youtube: String?,
    val destination: Destination,
)

data class Recommendation(
    val description: String,
    val destination: Destination,
    val spot: Spot,
    val cousin: Cousin
)

data class DestinationSpots(
    val destination: Destination,
    val spots: List<Spot>
)

data class SpotRecommendations(
    val spot: Spot,
    val recommendations: List<Recommendation>
)
