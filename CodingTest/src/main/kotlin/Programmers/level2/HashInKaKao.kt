class HashInKaKao {
    fun solution(cacheSize: Int, c: Array<String>): Int {
        val map = HashMap<String, Int>()
        val cities = c.map { it.uppercase() }
        var ans = 0

        if (cacheSize == 0) {
            ans = cities.size * 5
        } else if (cacheSize < cities.size) {

            for (i in cities.indices) {
                if (map.size < cacheSize) {
                    if (cities[i] in map) {
                        map[cities[i]] = i
                        ans++
                    } else {
                        map[cities[i]] = i
                        ans += 5
                    }
                } else {
                    if (cities[i] in map) {
                        map[cities[i]] = i
                        ans++
                    } else {
                        map.remove(map.keys.first { map[it] == map.minOf { v -> v.value } })
                        map[cities[i]] = i
                        ans += 5
                    }
                }
            }

        } else {
            ans = cities.size * 5
        }


        return ans
    }
}

fun main() {
    val h = HashInKaKao()
    println(
        h.solution(
            3,
            arrayOf("seoul", "seoul", "seoul", "tokyo", "seoul", "tokyo")
        )
    )
    println(h.solution(3, arrayOf("Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul")))
    println(h.solution(2, arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome")))
    println(h.solution(5, arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome")))
    println(h.solution(2, arrayOf("Jeju", "Pangyo", "NewYork", "newyork")))
    println(h.solution(0, arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA")))

}