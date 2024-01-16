class TupleInKaKao {
    fun solution(s: String): List<Int> {
        return s.replace("[^0-9]".toRegex(), ",").split(",").filter { it.isNotEmpty() }.map { it.toInt() }
            .groupBy { it }.entries
            .sortedByDescending { it.value.size }
            .map { it.key }
            .toList()
    }
}

fun main() {
    val t = TupleInKaKao()
    println(t.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
}