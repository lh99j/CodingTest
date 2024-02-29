import java.io.BufferedReader
import java.io.InputStreamReader

private const val MOD = 1_000_000_000

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val dp = Array(size + 1) { Array<Long>(10) { 0 } }

    for (i in 1..9) {
        dp[0][i] = 1
    }

    for (i in 1..size) {
        for (j in 0..9) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][1] % MOD
            } else if (j == 9) {
                dp[i][j] = dp[i - 1][8] % MOD
            } else {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD
            }
        }
    }

    println(dp[size - 1].sum() % MOD)
}