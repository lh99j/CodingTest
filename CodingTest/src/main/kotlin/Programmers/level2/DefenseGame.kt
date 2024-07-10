import java.util.*

class DefenseGame {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var total = n
        var cnt = k
        var rounds = 0
        val pq = PriorityQueue<Int>(compareByDescending { it })

        for (i in enemy.indices) {
            if (total >= enemy[i]) {
                total -= enemy[i]
                pq.offer(enemy[i])
                rounds++
            } else {
                if (cnt > 0) {
                    if (pq.isNotEmpty() && pq.peek() > enemy[i]) {
                        total += pq.poll()
                        total -= enemy[i]
                        pq.offer(enemy[i])
                    }
                    cnt--
                    rounds++
                } else {
                    break
                }
            }
        }

        return rounds
    }
}