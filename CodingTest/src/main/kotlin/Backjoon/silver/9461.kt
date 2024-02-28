import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val sb = StringBuilder()
    val dp = Array<Long>(101){ 0 }
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2

    for(i in 6..100){
        dp[i] = dp[i - 1] + dp[i - 5]
    }


    repeat(cnt) {
        sb.append(dp[br.readLine().toInt()]).append("\n")
    }
    println(sb)
}