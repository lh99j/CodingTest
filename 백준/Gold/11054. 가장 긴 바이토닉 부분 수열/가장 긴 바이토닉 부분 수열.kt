fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val dp1 = IntArray(n)
    val dp2 = IntArray(n)
    var ans = 0


    for(i in 0 until n) {
        dp1[i] = 1
        for (j in i - 1 downTo 0) {
            if(inputs[j] < inputs[i]) {
                dp1[i] = maxOf(dp1[i], dp1[j] + 1)
            }
        }
    }

    for(i in n - 1 downTo 0) {
        dp2[i] = 1
        for(j in i + 1 until n) {
            if(inputs[i] > inputs[j]) {
                dp2[i] = maxOf(dp2[i] , dp2[j] + 1)
            }
        }
    }

    for(i in 0 until n) {
        ans = maxOf(ans, dp1[i] + dp2[i])
    }

    println(ans - 1)
}
