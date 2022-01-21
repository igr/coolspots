package ac.obl.coolspots.db

fun loadCoolSpotsDatabases() {
    loadDestinationDatabase()
    loadSpotsDatabase()
    loadCousinDatabase()
    loadRecommendations()
    println("Cool Spots database loaded")
}

private fun String.intRef(): Int {
    return this.substringAfter('{').substringBefore('}').toInt()
}

private fun loadDestinationDatabase() {
    CsvData
        .destinations
        .map {
            Destination(
                name = it["name"]!!,
                country = it["country"]!!,
                countryName = it["countryName"]!!,
                center = LatLon(it["centerLat"]!!, it["centerLon"]!!),
                northEast = LatLon(it["northeastLat"]!!, it["northeastLon"]!!),
                southWest = LatLon(it["southwestLat"]!!, it["southwestLon"]!!),
            )
        }
        .forEach {
            Destinations.add(it)
        }
}

private fun loadSpotsDatabase() {
    CsvData
        .spots
        .map {
            Spot(
                destination = Destinations[it["destination"]!!.intRef()],
                name = it["name"]!!,
                address = it["address"]!!,
                location = LatLon(it["lat"]!!, it["lon"]!!),
                category = Category.valueOf(it["superCategory"]!!.uppercase()),
                type = it["type"],
                phone = it["phoneNumber"],
                website = it["website"],
                facebook = it["facebook"],
                instagram = it["instagram"]
            )
        }
        .forEach { Spots.add(it) }
}

private fun loadCousinDatabase() {
    CsvData
        .cousins
        .map {
            val profile = CsvData.profiles[it["cousinProfile"]!!.intRef()]

            Cousin(
                age = it["age"]!!.toInt(),
                firstName = it["firstName"]!!,
                lastName = it["lastName"]!!,
                sex = if (it["isMale"]!!.toBoolean()) Sex.MALE else Sex.FEMALE,
                about = it["tagline"]!!,
                welcomeMessage = it["welcomeMsg"]!!,
                description = it["description"]?: "",
                facebook = profile["facebookLink"],
                instagram = profile["instagramLink"],
                tumblr = profile["tumblrLink"],
                twitter = profile["twitter"],
                youtube = profile["youtube"],
                destination = Destinations[it["destination"]!!.intRef()]
            )
        }
        .forEach { Cousins.add(it) }
}

private fun loadRecommendations() {
    CsvData
        .recommendations
        .filter {
            it["cousin"] != "<null>" && it["spot"] != "<null>"
        }
        .map {
            Recommendation(
                description = it["_description"]!!,
                destination = Destinations[it["destination"]!!.intRef()],
                spot = Spots[it["spot"]!!.intRef()],
                cousin = Cousins[it["cousin"]!!.intRef()],
            )
        }
        .forEach { Recommendations.add(it) }
}
