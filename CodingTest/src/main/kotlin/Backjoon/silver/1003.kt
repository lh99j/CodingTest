import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val cnt = br.readLine().toInt()
    val dp = Array<Pair<Int, Int>>(41){ 0 to 0}

    dp[0] = Pair(1, 0)
    dp[1] = Pair(0, 1)

    for(i in 2..40){
        val a = dp[i - 1].first + dp[i - 2].first
        val b = dp[i - 1].second + dp[i - 2].second
        dp[i] = a to b
    }


    repeat(cnt){
        val input = br.readLine().toInt()
        sb.append("${dp[input].first} ${dp[input].second}").append("\n")
    }

    println(sb)
}