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

    //i번째 노드에서 다음 노드(i + 1) 까지의 거리는 1을 의미한다.
    for (i in 0 until destination) {
        graph[i].add(Node1446(i + 1, 1))
    }

    repeat(cnt) {
        val (s, d, l) = br.readLine().split(" ").map { it.toInt() }

        //만약 지름길 도착위치 - 시작 위치가 지름길 거리보다 크다면 지름길을 이용하는 것이 더 비효율 적이다.
        //또한 도착위치 > 최종위치라면 후진이 불가능하므로 추가하지 않는다.
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
        // 현재 노드, 현재 노드까지의 거리
        val (cNode, cDist) = pq.poll()

        //이미 갱신되어 있다는 뜻이다.
        if (distance[cNode] < cDist) {
            continue
        }

        graph[cNode].forEach {
            //다음 노드, 다음노드 까지의 거리
            val (nNode, nDist) = it

            //현재 노드까지의 거리 + 다음 노드까지의 거리
            val dist = cDist + nDist

            if (dist < distance[nNode]) {
                pq.add(Node1446(nNode, dist))
                distance[nNode] = dist
            }
        }
    }
}