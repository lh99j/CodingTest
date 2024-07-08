class MenuRenewal {
    private val map = mutableMapOf<String, Int>()

    fun solution(orders: Array<String>, course: IntArray): List<String> {
        val answer = mutableListOf<String>()
        course.forEach { c ->
            map.clear()

            orders.forEach { order ->
                back(0, c, order.chunked(1).sorted(), "")
            }

            val max = map.map { it.value }.maxOrNull() ?: -1
            if (max > 1) {
                for ((key, value) in map.entries) {
                    if (value == max) {
                        answer.add(key)
                    }
                }
            }
        }

        return answer.sorted()
    }

    private fun back(cur: Int, depth: Int, order: List<String>, str: String) {
        if (str.length == depth) {
            map[str] = map.getOrDefault(str, 0) + 1
            return
        }

        if (cur >= order.size) {
            return
        }

        back(cur + 1, depth, order, str)
        back(cur + 1, depth, order, str + order[cur])
    }
}

fun main() {
    val mr = MenuRenewal()
    println(mr.solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4)))
}