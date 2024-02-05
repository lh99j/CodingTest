import java.util.*

class StockPrice {
    // 풀이1
    fun solution1(prices: IntArray): Array<Int> {
        var s = Stack<Pair<Int, Int>>()
        var ans = Array(prices.size) { 0 }

        for (i in prices.indices) {
            if (s.empty()) {
                s.push(prices[i] to i)
            } else {
                var cnt = 1
                var flag = false
                while (s.peek().first > prices[i]) {
                    val p = s.pop()
                    ans[p.second] += cnt
                    flag = true
                    cnt++
                }

                if (flag) {
                    cnt--
                    val list = s.toList()
                    list.forEach { (value, idx) ->
                        ans[idx] += cnt
                    }
                }
                s.push(prices[i] to i)
            }
        }

        val rs = s.toMutableList()
        while (rs.size > 1) {
            val p = rs.removeFirst()
            ans[p.second] += rs.size
        }

        return ans
    }

    //풀이 2(개선된 풀이)
    fun solution2(prices: IntArray): Array<Int> {
        var ans = Array(prices.size) { 0 }
        var s = Stack<Int>()
        for (i in prices.indices) {
            while (s.isNotEmpty() && prices[s.peek()] > prices[i]) {
                val p = s.pop()
                ans[p] = i - p
            }
            s.push(i)
        }

        while (s.isNotEmpty()) {
            val p = s.pop()
            ans[p] = prices.size - p - 1
        }

        return ans
    }
}

fun main() {
    val sp = StockPrice()
    println(sp.solution2(intArrayOf(1, 2, 3, 2, 3)).joinToString(" "))
}