import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val pq = PriorityQueue(compareBy<Pair<Int, Int>>({ it.second }, { it.first }))

    repeat(n) {
        st = StringTokenizer(br.readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        pq.add(s to e)
    }

    var ans = 0
    var et = 0
    while (pq.isNotEmpty()) {
         val (s, e) = pq.poll()

        if(et <= s) {
            et = e
            ans++
        }
    }

    println(ans)
}