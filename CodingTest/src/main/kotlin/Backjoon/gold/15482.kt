import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val first = br.readLine()
    val second = br.readLine()
    val dp = Array(first.length + 1) { Array(second.length + 1) { 0 } }

    for (i in first.indices) {
        for (j in second.indices) {
            if(first[i] == second[j]){
                dp[i + 1][j + 1] = dp[i][j] + 1
            }else{
                dp[i + 1][j + 1] = maxOf(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }

    println(dp[first.length][second.length])
}