class Hopscotch {
    fun solution(land: Array<IntArray>): Int {
        var ans = 0
        var dp = Array(land.size) { land[it].copyOf() }

        for (i in 1 until land.size) {
            for (j in 0..3) {
                for (k in 0..3) {
                    if (k == j) {
                        continue
                    }

                    dp[i][j] = maxOf(dp[i][j], dp[i - 1][k] + land[i][j])
                }
            }
        }

        return dp[dp.size - 1].max()
    }
}

fun main() {
    val h = Hopscotch()
    println(h.solution(arrayOf(intArrayOf(1, 1, 3, 1), intArrayOf(2, 3, 2, 2), intArrayOf(1, 4, 1, 1))))
}