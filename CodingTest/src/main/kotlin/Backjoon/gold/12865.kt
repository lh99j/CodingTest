import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (cnt, tw) = br.readLine().split(" ").map { it.toInt() }
    val w = Array(cnt + 1) { 0 }
    val v = Array(cnt + 1) { 0 }
    val dp = Array(cnt + 1) { Array(tw + 1) { 0 } }

    repeat(cnt) { idx ->
        val (iw, iv) = br.readLine().split(" ").map { it.toInt() }
        w[idx + 1] = iw
        v[idx + 1] = iv
    }

    for (i in 1..cnt) {
        for (j in 1..tw) {
            if (w[i] > j) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = maxOf(v[i] + dp[i - 1][j - w[i]], dp[i - 1][j])
            }
        }
    }

    println(dp[cnt][tw])
}