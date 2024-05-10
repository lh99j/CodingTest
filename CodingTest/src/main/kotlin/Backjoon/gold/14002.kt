import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(size){ 0 }

    for(i in 0 until size){
        dp[i] = 1

        for(j in 0 until i){
            if(inputs[i] > inputs[j]){
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }
    var len = dp.max()
    val ans = Array(len) { 0 }
    println(len)

    for(i in size - 1 downTo 0){
        if(dp[i] == len){
            ans[--len] = inputs[i]
        }
    }

    println(ans.joinToString(" "))

}