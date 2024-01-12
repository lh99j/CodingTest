class SumOfSubsequence {
    fun solution(elements: IntArray): Int {
        var check = mutableSetOf<Int>()
        var dp = elements.toMutableList()

        check.addAll(dp)

        for(i in 1 until elements.size){
            for(j in dp.indices){
                val t = i + j
                if(t < elements.size){
                    dp[j] = dp[j] + elements[t]
                }else{
                    dp[j] = dp[j] + elements[t - elements.size]
                }
            }
            check.addAll(dp)
        }

        return check.size
    }
}

fun main() {
    val sos = SumOfSubsequence()
    println(sos.solution(intArrayOf(7, 9, 1, 1, 4)))
}