import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val t = st.nextToken().toInt()
    val sb = StringBuilder()

    val minQ: PriorityQueue<Int> = PriorityQueue()
    val maxQ: PriorityQueue<Int> = PriorityQueue(compareByDescending { it })

    repeat(t) {
        st = StringTokenizer(br.readLine())
        val size = st.nextToken().toInt()
        var cnt = 1
        sb.append((size / 2) + 1).append("\n")
        minQ.clear()
        maxQ.clear()

        repeat((size / 10) + 1) {
            st = StringTokenizer(br.readLine())

            while(st.hasMoreTokens()) {
                val num = st.nextToken().toInt()

                //넣고
                if(cnt % 2 != 0) {
                    maxQ.offer(num)
                } else {
                    minQ.offer(num)
                }

                //재구성하고
                if(maxQ.isNotEmpty() && minQ.isNotEmpty()) {
                    val minP = minQ.peek()
                    val maxP = maxQ.peek()

                    if(minP < maxP) {
                        val min = minQ.poll()
                        val max = maxQ.poll()

                        maxQ.offer(min)
                        minQ.offer(max)
                    }
                }

                //홀수라면 출력하기
                if(cnt % 2 != 0) {
                    sb.append("${maxQ.peek()} ")
                }

                cnt++
            }
        }

        sb.append("\n")
    }

    println(sb)
}