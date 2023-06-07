import java.util.*


class QueueSumEqual {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0

        var q1: Queue<Int> = LinkedList()
        var q2: Queue<Int> = LinkedList()

        for(i in queue1.indices){
            q1.offer(queue1[i])
        }

        for(i in queue2.indices){
            q2.offer(queue2[i])
        }

        var q1Sum = q1.sum()
        var q2Sum = q2.sum()

        while(q1Sum != q2Sum){
            answer ++

            if(q1Sum > q2Sum){
                val q1Pool = q1.poll()
                q1Sum -= q1Pool
                q2Sum += q1Pool
                q2.offer(q1Pool)
            }else{
                val q2Pool = q2.poll()
                q2Sum -= q2Pool
                q1Sum += q2Pool
                q1.offer(q2Pool)
            }

            if(answer == (q1.size + q2.size) * 2){
                return -1
            }
        }

        return answer
    }
}

fun main(args: Array<String>){
    val qse = QueueSumEqual()
}