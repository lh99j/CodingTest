class Tiling {
    fun solution(n: Int): Int {
        if(n <= 3){
            return n
        }
        val dp = IntArray(n + 1) { 0 }
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3

        for(i in 4..n){
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD
        }

        return dp[n]
    }

    companion object{
        private const val MOD = 1_000_000_007
    }
}