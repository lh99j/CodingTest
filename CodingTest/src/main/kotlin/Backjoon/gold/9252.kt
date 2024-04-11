import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val first = br.readLine()
    val second = br.readLine()
    val dp = Array(first.length + 1) { Array(second.length + 1) { 0 } }

    for (i in first.indices) {
        for (j in second.indices) {
            if (first[i] == second[j]) {
                dp[i + 1][j + 1] = dp[i][j] + 1
            } else {
                dp[i + 1][j + 1] = maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }
    }

    val lcs = dp[first.length][second.length]
    if (lcs > 0) {
        println(lcs)
        var x = first.length
        var y = second.length
        var str = ""

        while (str.length < lcs) {
            if(dp[x][y] == dp[x - 1][y]){
                x--
            }else if(dp[x][y] == dp[x][y - 1]){
                y--
            }else{
                str += first[x - 1]
                x--
                y--
            }
        }

        println(str.reversed())
    } else {
        println("0")
    }
}