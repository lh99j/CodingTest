import java.io.*
import java.util.*

private data class Factory1939(val next: Int, val cost: Int)

private lateinit var graph: Array<MutableList<Factory1939>>
private const val INF = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    graph = Array<MutableList<Factory1939>>(N + 1) { mutableListOf() }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        graph[start].add(Factory1939(end, cost))
        graph[end].add(Factory1939(start, cost))
    }

    st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    val dist = dijkstra(start)
    println(dist[end])
}

private fun dijkstra(start: Int): IntArray {
    val dist = IntArray(graph.size) { 0 }
    val pq = PriorityQueue<Factory1939>(compareByDescending { it.cost })

    dist[start] = INF
    pq.add(Factory1939(start, INF))

    while (pq.isNotEmpty()) {
        val (cNode, cCost) = pq.poll()

        if(cCost < dist[cNode]){
            continue
        }

        graph[cNode].forEach {
            val nNode = it.next
            val nCost = it.cost
            val minCost = minOf(nCost, cCost)

            if(minCost > dist[nNode]){
                pq.offer(Factory1939(nNode, minCost))
                dist[nNode] = minCost
            }
        }
    }

    return dist
}