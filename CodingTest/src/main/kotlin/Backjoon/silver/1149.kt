import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    var values = Array<MutableList<Int>>(size) { mutableListOf() }
    var dp = Array(size){ Array(3) { Int.MAX_VALUE } }

    repeat(size) { idx ->
        val value = br.readLine().split(" ").map { it.toInt() }
        values[idx].addAll(value)
    }

    for (i in 0 until dp[0].size) {
        dp[0][i] = values[0][i]
    }

    for (i in 1 until dp.size) {
        for (j in 0 until 3) {

            for (k in 0 until 3) {
                if (j == k) {
                    continue
                }

                dp[i][j] = minOf(dp[i][j], dp[i - 1][k] + values[i][j])
            }

        }
    }

    println(dp[dp.size - 1].min())

}