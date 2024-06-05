class MountainTiling {
    private val MOD = 10_007
    fun solution(n: Int, tops: IntArray): Int {
        val dp = Array(n + 1) { IntArray(2) { 0 } }
        dp[0][0] = 0
        dp[0][1] = 1

        for(i in 1..n){
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD

            if(tops[i - 1] == 1){
                dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 3) % MOD
            }else{
                dp[i][1] = (dp[i - 1][0] + 2 * dp[i - 1][1]) % MOD
            }
        }

        return (dp[n][0] + dp[n][1]) % MOD
    }
}