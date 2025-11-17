import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.system.exitProcess

private var p = intArrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
    var total = 0
    var ans = 0

    while(true) {
        var st = StringTokenizer(br.readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()

        if(m == 0 && n == 0) {
            println(sb)
            break
        }

        p = IntArray(m) { it }
        total = 0
        ans = 0

        repeat(n) {
            st = StringTokenizer(br.readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            val v = st.nextToken().toInt()
            total += v

            pq.offer(Triple(x, y, v))

        }

        while(pq.isNotEmpty()) {
            val (x, y, v) = pq.poll()
            if(find(x) != find(y)) {
                union(x, y)
                ans += v
            }
        }

        sb.append(total - ans).append("\n")
    }
}

private fun union(x: Int, y: Int){
    val px = find(x)
    val py = find(y)

    p[px] = py
}

private fun find(x: Int): Int {
    if(x == p[x]) {
        return x
    }

    p[x] = find(p[x])
    return p[x]
}
