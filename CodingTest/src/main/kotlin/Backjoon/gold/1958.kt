import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val first = br.readLine()
    val second = br.readLine()
    val third = br.readLine()

    val dp = Array(first.length + 1) { Array(second.length + 1) { Array(third.length + 1) { 0 } } }

    for(i in first.indices){
        for(j in second.indices){
            for(k in third.indices){
                if(first[i] == second[j] && second[j] == third[k]){
                    dp[i + 1][j + 1][k + 1] = dp[i][j][k] + 1
                }else{
                    dp[i + 1][j + 1][k + 1] = maxOf(dp[i][j + 1][k + 1], dp[i + 1][j][k + 1], dp[i + 1][j + 1][k])
                }
            }
        }
    }

    println(dp[first.length][second.length][third.length])
}