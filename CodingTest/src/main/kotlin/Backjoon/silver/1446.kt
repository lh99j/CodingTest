import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private data class Node1446(val node: Int, val dist: Int) : Comparable<Node1446> {
    override fun compareTo(other: Node1446): Int = dist - other.dist
}

lateinit var distance: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (cnt, destination) = br.readLine().split(" ").map { it.toInt() }
    distance = Array(destination + 1) { Int.MAX_VALUE }
    val graph = Array<MutableList<Node1446>>(destination + 1) { mutableListOf() }

    for (i in 0 until destination) {
        graph[i].add(Node1446(i + 1, 1))
    }

    repeat(cnt) {
        val (s, d, l) = br.readLine().split(" ").map { it.toInt() }
        if (d - s > l && d <= destination) {
            graph[s].add(Node1446(d, l))
        }
    }

    dijkstra(graph)
    println(distance[destination])

}

private fun dijkstra(graph: Array<MutableList<Node1446>>) {
    val pq = PriorityQueue<Node1446>()
    distance[0] = 0
    pq.add(Node1446(0, 0))

    while (pq.isNotEmpty()) {
        val (cNode, cDist) = pq.poll()

        if (distance[cNode] < cDist) {
            continue
        }

        graph[cNode].forEach {
            val (nNode, nDist) = it
            val dist = cDist + nDist

            if (dist < distance[nNode]) {
                pq.add(Node1446(nNode, dist))
                distance[nNode] = dist
            }
        }
    }
}