import java.util.*

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private const val INF = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val items = br.readLine().split(" ").map { it.toInt() }
    var ans = 0
    graph = Array(n + 1) { mutableListOf() }

    repeat(r) {
        val (start, end, value) = br.readLine().split(" ").map { it.toInt() }
        graph[start].add(end to value)
        graph[end].add(start to value)
    }

    for (i in 1..n) {
        val dist = getDist(i)
        ans = maxOf(ans, getItemValue(dist, items, m))
    }

    println(ans)
}

private fun getDist(start: Int): IntArray {
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = IntArray(graph.size) { INF }

    q.offer(start to 0)
    dist[start] = 0

    while (q.isNotEmpty()) {
        val (cn, cv) = q.poll()

        if (cv > dist[cn])
            continue

        graph[cn].forEach { next ->
            val nv = next.second + cv

            if (nv < dist[next.first]) {
                q.offer(next.first to nv)
                dist[next.first] = nv
            }
        }
    }

    return dist
}

private fun getItemValue(dist: IntArray, items: List<Int>, m: Int): Int {
    var out = 0

    for(i in 1 until dist.size){
        if(dist[i] <= m){
            out += items[i - 1]
        }
    }

    return out
}