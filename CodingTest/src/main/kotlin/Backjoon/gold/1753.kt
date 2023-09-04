import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

private lateinit var dist: Array<Int>

private data class Dot1753(var first: Int, var second: Int)

private data class Node(val node: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = dist - other.dist
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val root = br.readLine().toInt()
    val sb = StringBuilder()

    val graph = Array<MutableList<Node>>(V + 1) { mutableListOf() }
    dist = Array<Int>(V + 1) { Int.MAX_VALUE }

    graph[0].add(Node(0, 0))

    repeat(E) {
        var (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Node(b, c))
    }

    dijkstra(graph, root)

    for (i in 1..V) {
        if (dist[i] == Int.MAX_VALUE) {
            sb.append("INF").append("\n")
        } else {
            sb.append(dist[i]).append("\n")
        }
    }

    println(sb)
}

private fun dijkstra(graph: Array<MutableList<Node>>, start: Int) {
    var q = PriorityQueue<Node>()

    dist[start] = 0
    q.offer(Node(start, 0))

    while (q.isNotEmpty()) {
        val temp = q.poll()
        val cNode = temp.node
        val cCost = temp.dist

        if (dist[cNode] < cCost)
            continue

        graph[cNode].forEach {
            var nNode = it.node
            var nCost = cCost + it.dist

            if (nCost < dist[nNode]) {
                q.offer(Node(nNode, nCost))
                dist[nNode] = nCost
            }
        }
    }
}