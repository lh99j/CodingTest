class PredictGame {
    fun solution(n: Int, a: Int, b: Int): Int {
        var ans = 1
        var x = a
        var y = b

        while ((x - 1) / 2 != (y - 1) / 2) {
            x = ((if (x - 1 == 0) 1 else x - 1) / 2) + 1
            y = ((if (y - 1 == 0) 1 else y - 1) / 2) + 1
            ans++
        }

        return ans
    }
}

fun main() {
    val pg = PredictGame()
    println(pg.solution(16, 1, 3))
}