import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

private data class D1744(val x: Int, val y: Int)
private val p = mutableMapOf<D1744, D1744>()

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val inputs = mutableListOf<D1744>()
    val pq = PriorityQueue<Triple<D1744, D1744, Double>>(compareBy { it.third})
    var ans = 0.0

    repeat(n) {
        st = StringTokenizer(br.readLine())
        inputs.add(D1744(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    for(i in 0 until n) {
        val f = inputs[i]
        for(j in i + 1 until n) {
            val s = inputs[j]
            val v = sqrt((f.x - s.x).toDouble().pow(2) + (f.y - s.y).toDouble().pow(2))

            pq.offer(Triple(f, s, v))
        }

        p[f] = f
    }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        union(inputs[st.nextToken().toInt() - 1], inputs[st.nextToken().toInt() - 1])
    }

    while(pq.isNotEmpty()) {
        val (f, s, v) = pq.poll()

        if(find(f) != find(s)) {
            union(f, s)
            ans += v
        }
    }

    println(String.format("%.2f", ans))
}

private fun union(x: D1744, y: D1744) {
    val px = find(x)
    val py = find(y)

    p[px] = py
}

private fun find(x: D1744): D1744 {
    if(x == p[x]!!) {
        return x
    }

    p[x] = find(p[x]!!)
    return p[x]!!
}
