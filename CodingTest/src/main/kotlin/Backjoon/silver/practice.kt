import java.util.*

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var ans = 0
        val pq = PriorityQueue<Int>(compareByDescending { it })

        var total = n
        var cnt = 0

        for (i in enemy.indices) {
            if (total < enemy[i] && cnt == k) {
                break
            }

            if (total >= enemy[i]) {
                pq.offer(enemy[i])
                total -= enemy[i]
                ans++
            } else {
                if (pq.isNotEmpty() && cnt < k && total + pq.peek() >= enemy[i]) {
                    cnt++
                    total += pq.poll() - enemy[i]
                    pq.offer(enemy[i])
                    ans++
                } else if (cnt < k) {
                    cnt++
                    ans++
                } else {
                    break
                }
            }
        }

        return ans
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution(7, 3, intArrayOf(4, 2, 4, 5, 3, 3, 1))) // 예시 1
    println(solution.solution(2, 4, intArrayOf(3, 3, 3, 3))) // 예시 2
}
