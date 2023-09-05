import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

private data class Node1916(val node: Int, val dist: Int): Comparable<Node1916>{
    override fun compareTo(other: Node1916): Int = dist - other.dist
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    var adj = Array<MutableList<Node1916>>(n + 1){ mutableListOf() }
    var dist = Array<Int>(n + 1){ Int.MAX_VALUE }

    adj[0].add(Node1916(0, 0))

    repeat(m){
        val (start, end, dist) = br.readLine().split(" ").map { it.toInt() }
        adj[start].add(Node1916(end, dist))
    }

    var (start, end) = br.readLine().split(" ").map { it.toInt() }

    dijkstra(adj, dist, start)

    println(dist[end])
}

private fun dijkstra(adj: Array<MutableList<Node1916>>, dist: Array<Int>, start: Int){
    val q = PriorityQueue<Node1916>()

    dist[start] = 0
    q.offer(Node1916(start, 0 ))

    while(q.isNotEmpty()){
        val popNode = q.poll()
        val cNode = popNode.node
        val cDist = popNode.dist

        if(cDist > dist[cNode])
            continue

        adj[cNode].forEach {
            val nNode = it.node
            val nDist = it.dist + cDist

            if(nDist < dist[nNode]){
                q.offer(Node1916(nNode, nDist))
                dist[nNode] = nDist
            }
        }
    }
}