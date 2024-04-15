import java.util.*

class TaxiFee {
    private lateinit var graph: Array<MutableList<Node>>
    private var size = 0
    private data class Node(val node: Int, val cost: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = cost - other.cost
    }
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var ans: Int = Int.MAX_VALUE
        size = n
        graph = Array<MutableList<Node>>(n + 1){ mutableListOf() }
        graph[0].add(Node(0, 0))

        fares.forEach {
            graph[it[0]].add(Node(it[1], it[2]))
            graph[it[1]].add(Node(it[0], it[2]))
        }

        val dDist = dijkstra(s)
        val aDist = dijkstra(a)
        val bDist = dijkstra(b)

        for(i in 1..n){
            if(s == i)
                continue

            ans = minOf(ans, dDist[i] + aDist[i] + bDist[i])
        }

        return ans
    }

    private fun dijkstra(s: Int): Array<Int>{
        var dist: Array<Int> = Array(size + 1){ Int.MAX_VALUE }
        val q: PriorityQueue<Node> = PriorityQueue()

        q.offer(Node(s, 0))
        dist[s] = 0

        while(q.isNotEmpty()){
            val (cNode, cCost) = q.poll()

            if(dist[cNode] < cCost)
                continue

            graph[cNode].forEach {
                val nNode = it.node
                val nCost = it.cost + cCost

                if(nCost < dist[nNode]){
                    dist[nNode] = nCost
                    q.offer(Node(nNode, nCost))
                }
            }
        }

        return dist
    }
}