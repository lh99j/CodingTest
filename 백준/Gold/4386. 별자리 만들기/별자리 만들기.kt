import java.lang.Math.pow
import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

private val p = mutableMapOf<Pair<Double, Double>, Pair<Double, Double>>()

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val graph = mutableMapOf<Double, List<Double>>()
    val visited = mutableMapOf<Pair<Double, Double>, Boolean>()
    val pq = PriorityQueue<Triple<Pair<Double, Double>, Pair<Double, Double>, Double>>(compareBy { it.third })
    val input = mutableListOf<Pair<Double, Double>>()
    var ans: Double = 0.0

    repeat(n) {
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toDouble()
        val y = st.nextToken().toDouble()

        p[x to y] = x to y
        input.add(x to y)
    }

    for(i in 0 until n) {
        val (x1, y1) = input[i]
        for(j in i + 1 until n) {
            val (x2, y2) = input[j]

            val num = sqrt((x1 - x2).pow(2) + (y1 - y2).pow(2))

            pq.offer(Triple(x1 to y1, x2 to y2, num))
        }
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

private fun union(x: Pair<Double, Double>, y: Pair<Double, Double>) {
    val px = find(x)
    val py = find(y)

    p[px] = py
}

private fun find(x: Pair<Double, Double>): Pair<Double, Double> {
    if(x == p[x]!!) {
        return x
    }

    p[x] = find(p[x]!!)

    return p[x]!!
}
