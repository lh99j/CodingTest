import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs

private lateinit var dp: Array<Array<Boolean>>
private lateinit var balls: List<Int>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ballCnt = br.readLine().toInt()
    balls = br.readLine().split(" ").map { it.toInt() }
    val cnt = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    dp = Array(ballCnt + 1) { Array(40001) { false } }

    dp(0, ballCnt, 0)

    inputs.forEach {
        if(dp[ballCnt][it]){
            print("Y ")
        }else{
            print("N ")
        }
    }
}

private fun dp(cnt: Int, size: Int, num: Int){
    if(dp[cnt][num]) return
    dp[cnt][num] = true
    if(cnt == size) return

    dp(cnt + 1, size, num + balls[cnt])
    dp(cnt + 1, size, num)
    dp(cnt + 1, size, abs(num - balls[cnt]))
}