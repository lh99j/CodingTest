import java.io.BufferedReader
import java.io.InputStreamReader

private var maxValue = -1
private var maxSize = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (size, start, max) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(size + 1) { Array(max + 1) { false } }

    dp[0][start] = true

    for (i in 1..size) {
        for (j in 0..max) {
            if (!dp[i - 1][j]) {
                continue
            }

            if (j - nums[i - 1] >= 0) {
                dp[i][j - nums[i - 1]] = true
            }

            if (j + nums[i - 1] <= max) {
                dp[i][j + nums[i - 1]] = true
            }
        }
    }

    println(dp[size].indexOfLast { it } ?: -1)
}