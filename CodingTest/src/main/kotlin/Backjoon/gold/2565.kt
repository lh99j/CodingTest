import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val temp = mutableListOf<Pair<Int, Int>>()
    val dp = Array(size) { 0 }

    repeat(size){
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        temp.add(x to y)
    }

    val inputs = temp.sortedBy { it.first }.map { it.second }

    for(i in 0 until size){
        dp[i] = 1
        for(j in 0 until i){
            if(inputs[i] > inputs[j]){
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    println(size - dp.max())
}