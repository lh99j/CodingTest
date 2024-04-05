import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val dp1 = Array(size) { 0 }
    val dp2 = Array(size){ 0 }


    for (i in 0 until size) {
        dp1[i] = 1
        for (j in 0 until i) {
            if(inputs[i]  > inputs[j]){
                dp1[i] = maxOf(dp1[j] + 1, dp1[i])
            }
        }
    }

    for(i in size - 1 downTo 0){
        dp2[i] = 1

        for(j in i + 1 until size){
            if(inputs[i] > inputs[j]){
                dp2[i] = maxOf(dp2[j] + 1, dp2[i])
            }
        }
    }

    var max = 0
    for(i in 0 until size){
        max = maxOf(max, dp1[i] + dp2[i] - 1)
    }


    println(max)
}