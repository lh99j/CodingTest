import java.util.PriorityQueue

class Delivery {

    data class Node(val node: Int, val dist: Int): Comparable<Node>{
        override fun compareTo(other: Node): Int = dist - other.dist
    }

    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        var adj = Array<MutableList<Node>>(51){ mutableListOf() }
        var dist = Array<Int>(road.size) { Int.MAX_VALUE }

        road.forEach {
            adj[it[0]].add(Node(it[1], it[2]))
            adj[it[1]].add(Node(it[0], it[2]))
        }

        dijkstra(adj, dist)

        dist.forEach {
            if(it <= k){
                answer++
            }
        }

        return answer
    }

    fun dijkstra(adj: Array<MutableList<Node>>, dist: Array<Int>){
        val q = PriorityQueue<Node>()

        dist[1] = 0
        q.offer(Node(1, 0))

        while (q.isNotEmpty()){
            val temp = q.poll()
            val cNode = temp.node
            val cDist = temp.dist

            if(dist[cNode] < cDist)
                continue

            adj[cNode].forEach {
                val nNode = it.node
                val nDist = it.dist + cDist

                if(nDist < dist[nNode]){
                    q.offer(Node(nNode, nDist))
                    dist[nNode] = nDist
                }
            }
        }

    }
}

fun main(args: Array<String>){

}