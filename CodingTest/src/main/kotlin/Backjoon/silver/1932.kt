import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val input = Array<MutableList<Int>>(size) { mutableListOf() }
    val dp = Array<MutableList<Int>>(size) { mutableListOf() }

    repeat(size) { idx ->
        val nums = br.readLine().split(" ").map { it.toInt() }
        dp[idx] = MutableList(nums.size) { 0 }
        input[idx].addAll(nums)
    }

    dp[0][0] = input[0][0]

    for (i in 1 until size) {
        for (j in 0 until input[i].size) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][0] + input[i][0]
            } else if (j == input[i].size - 1) {
                dp[i][j] = dp[i - 1][dp[i - 1].size - 1] + input[i][input[i].size - 1]
            }else{
                val max = maxOf(dp[i - 1][j - 1] + input[i][j], dp[i - 1][j] + input[i][j])
                dp[i][j] = max
            }
        }
    }

    println(dp[size - 1].max())
}