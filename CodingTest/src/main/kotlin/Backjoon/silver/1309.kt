import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val dp = Array(size + 1){ 0 }


    if(size == 1){
        println(3)
    }else{
        dp[0] = 1
        dp[1] = 3

        for(i in 2..size){
            dp[i] = (2 * dp[i - 1] + dp[i - 2]) % 9901
        }

        println(dp[size])
    }
}