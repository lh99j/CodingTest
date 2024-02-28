import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toInt()
    var dp = Array(input + 1) { Int.MAX_VALUE }

    dp[input] = 0
    for (i in input downTo 1) {
        if (i % 2 == 0) {
            dp[i / 2] = minOf(dp[i / 2], dp[i] + 1)
        }
        if (i % 3 == 0) {
            dp[i / 3] = minOf(dp[i / 3], dp[i] + 1)
        }
        dp[i - 1] = minOf(dp[i - 1], dp[i] + 1)
    }

    println(dp[1])
}