import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var dp = Array(21) { Array(21) { Array(21) { 0 } } }
    val sb = StringBuilder()

    for (i in 0..20) {
        for (j in 0..20) {
            for (k in 0..20) {
                if (i <= 0 || j <= 0 || k <= 0) {
                    dp[i][j][k] = 1
                } else if (i < j && j < k) {
                    dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k]
                } else {
                    dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1]
                }
            }
        }
    }


    while (true) {
        var (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) {
            break
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            sb.append("w($a, $b, $c) = 1").append("\n")
        }else if(a > 20 || b > 20 || c > 20){
            sb.append("w($a, $b, $c) = ${dp[20][20][20]}").append("\n")
        }
        else {
            sb.append("w($a, $b, $c) = ${dp[a][b][c]}").append("\n")
        }

    }
    println(sb)
}