import java.util.PriorityQueue

class MoreSpicy {
    fun solution(scoville: IntArray, K: Int): Int {
        val q = PriorityQueue<Int>()
        var ans = 0

        scoville.forEach {
            q.offer(it)
        }

        while (q.size >= 2) {
            val x = q.poll()
            val y = q.poll()

            if(x >= K && y >= K){
                q.offer(x)
                q.offer(y)
                break
            }

            q.offer(x + (y * 2))
            ans++
        }

        return if(q.peek() < K){
            -1
        } else
            ans
    }
}

fun main(){
    val ms = MoreSpicy()
    println(ms.solution(intArrayOf(1, 2, 3, 9, 10, 12), 7))
}