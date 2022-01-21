package ac.obl.coolspots.db

sealed class Database<T> {
    protected val data = mutableListOf<T>()

    fun add(value: T) {
        data.add(value)
    }
    operator fun get(index: Int): T {
        return data[index]
    }

    fun forEach(action: (T) -> Unit) {
        data.forEach(action)
    }

    fun <R> map(transform: (T) -> R): List<R> {
        return data.map(transform);
    }
}

object Cousins : Database<Cousin>()

object Destinations : Database<Destination>()

object Spots : Database<Spot>() {
    fun of(destination: Destination) : DestinationSpots {
        return data
            .filter { it.destination == destination }
            .let {
                DestinationSpots(destination, it)
            }
    }
}

object Recommendations : Database<Recommendation>() {
    fun of(spot: Spot) : SpotRecommendations {
        return data
            .filter { it.spot == spot }
            .let {
                SpotRecommendations(spot, it)
            }
    }
}
