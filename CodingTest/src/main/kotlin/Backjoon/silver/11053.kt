import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    var dp = Array(size) { 0 }

    for(i in 0 until size){
        dp[i] = 1
        for(j in 0 until i){
            if(inputs[j] < inputs[i]){
                dp[i] = maxOf(dp[j] + 1, dp[i])
            }
        }
    }

    println(dp.max())
}