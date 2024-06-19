import java.io.*
import java.util.*

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private const val INF = Int.MAX_VALUE
private lateinit var root: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    graph = Array(N + 1) { mutableListOf() }
    root = IntArray(N + 1) { INF }

    repeat(M) { idx ->
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        graph[start].add(end to cost)
        graph[end].add(start to cost)
    }

    dijkstra(1)

    println(N - 1)
    for (i in 2..N) {
        println("$i ${root[i]}")
    }
}

private fun dijkstra(start: Int): IntArray {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = IntArray(graph.size) { INF }

    pq.offer(start to 0)
    dist[start] = 0

    while (pq.isNotEmpty()) {
        val (cNode, cCost) = pq.poll()

        if (cCost > dist[cNode]) {
            continue
        }

        graph[cNode].forEach {
            val nNode = it.first
            val nCost = it.second + cCost

            if (nCost < dist[nNode]) {
                pq.offer(nNode to nCost)
                dist[nNode] = nCost

                root[nNode] = cNode
            }
        }
    }

    return dist
}