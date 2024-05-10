import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val sb = StringBuilder()
    val dp = Array(11){ 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for(i in 4..10){
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    }

    repeat(size){
        sb.append(dp[br.readLine().toInt()]).append("\n")
    }

    println(sb)
}