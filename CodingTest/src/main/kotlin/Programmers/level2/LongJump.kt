class LongJump {
    fun solution(n: Int): Long {
        var dp = Array(2001){ 0 }
        dp[1] = 1
        dp[2] = 2

        for(i in 3..n){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567
        }
        return dp[n].toLong()
    }

}

fun main(){
    val lj = LongJump()
    println(lj.solution(1000))
}