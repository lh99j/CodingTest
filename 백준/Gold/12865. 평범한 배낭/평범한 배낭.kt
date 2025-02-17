fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(k + 1) { 0 } }

    val w = IntArray(n + 1) { 0 }
    val v = IntArray(n + 1) { 0 }

    repeat(n) { idx ->
        val (i1, i2) = br.readLine().split(" ").map { it.toInt() }
        w[idx + 1] = i1
        v[idx + 1] = i2
    }

    for (i in 1..n) {
        for (j in 1..k) {
            if (w[i] > j) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i])
            }
        }
    }
    
    println(dp[n][k])
}
