import java.util.*

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private const val INF = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(tc) {
        val (n, d, c) = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n + 1) { mutableListOf() }

        repeat(d) {
            val (end, start, dist) = br.readLine().split(" ").map { it.toInt() }
            graph[start].add(end to dist)
        }

        val result = getVirus(c)
        sb.append("${result.first} ${result.second}").append("\n")
    }

    println(sb)
}

private fun getVirus(start: Int): Pair<Int, Int> {
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = IntArray(graph.size) { INF }

    q.offer(start to 0)
    dist[start] = 0

    while (q.isNotEmpty()) {
        val (cn, cc) = q.poll()

        if (cc > dist[cn])
            continue

        graph[cn].forEach { next ->
            val nNode = next.first
            val nCost = cc + next.second

            if(nCost < dist[nNode]){
                q.offer(nNode to nCost)
                dist[nNode] = nCost
            }
        }
    }

    return dist.count { it != INF } to dist.filter { it != INF }.max()
}