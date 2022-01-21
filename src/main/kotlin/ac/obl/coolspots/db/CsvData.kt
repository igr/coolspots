package ac.obl.coolspots.db

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

private fun loadResourceAsText(it: String): String {
    val resource = Thread.currentThread().contextClassLoader.getResource(it)
    requireNotNull(resource) { "Resource $it not found" }
    return resource.readText()
}

private fun loadCsvFromResource(resourceName: String): List<Map<String, String>> {
    val csvData = loadResourceAsText(resourceName)
    return csvReader().readAllWithHeader(csvData)
}

object CsvData {
    val cousins by lazy { loadCsvFromResource("RCousin.csv") }
    val profiles by lazy { loadCsvFromResource("RCousinProfile.csv") }
    val destinations by lazy { loadCsvFromResource("RDestination.csv") }
    val spots by lazy { loadCsvFromResource("RSpot.csv") }
    val recommendations by lazy { loadCsvFromResource("RRecommendation.csv") }
}
