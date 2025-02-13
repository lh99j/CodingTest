import java.util.*

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private const val INF = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { mutableListOf() }

    repeat(m) {
        val (start, end, value) = br.readLine().split(" ").map { it.toInt() }
        graph[start].add(end to value)
        graph[end].add(start to value)
    }

    println(getMinDistance(n))
}

private fun getMinDistance(n: Int): Int {
    val dist = IntArray(n + 1) { INF }
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    q.offer(1 to 0)
    dist[1] = 0

    while (q.isNotEmpty()) {
        val (cNode, cCost) = q.poll()

        if (cCost > dist[cNode])
            continue

        graph[cNode].forEach { next ->
            val nextNode = next.first
            val nextCost = cCost + next.second

            if (nextCost < dist[nextNode]) {
                q.offer(nextNode to nextCost)
                dist[nextNode] = nextCost
            }
        }
    }

    return dist[n]
}
