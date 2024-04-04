import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val inputs = mutableListOf<Int>()

    repeat(size) {
        inputs.add(br.readLine().toInt())
    }

    if (size < 3) {
        println(inputs.sum())
    } else {
        val dp = Array(size) { 0 }

        dp[0] = inputs[0]
        dp[1] = inputs[0] + inputs[1]
        dp[2] = maxOf(inputs[0] + inputs[1], maxOf(inputs[1] + inputs[2], inputs[0] + inputs[2]))

        for(i in 3 until size){
            dp[i] = maxOf(dp[i - 2] + inputs[i], dp[i - 3] + inputs[i - 1] + inputs[i], dp[i - 1])
        }

        println(dp.max())
    }
}