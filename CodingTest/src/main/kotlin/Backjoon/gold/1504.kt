import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private var e = 0
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (tn, te) = br.readLine().split(" ").map { it.toInt() }
    n = tn
    e = te
    graph = Array<MutableList<Pair<Int, Int>>>(n + 1){ mutableListOf() }
    graph[0].add(0 to 0)
    repeat(e){
        val (s, d, c) = br.readLine().split(" ").map { it.toInt() }
        graph[s].add(d to c)
        graph[d].add(s to c)
    }

    val (v1, v2) = br.readLine().split(" ").map { it.toInt() }

    val sDist = dijkstra(1)
    val v1Dist = dijkstra(v1)
    val v2Dist = dijkstra(v2)

    val ans = minOf(sDist[v1] + v1Dist[v2] + v2Dist[n], sDist[v2] + v1Dist[n] + v2Dist[v1])
    println(if(sDist[v1] == Int.MAX_VALUE || sDist[v2] == Int.MAX_VALUE || sDist[n] == Int.MAX_VALUE) -1 else ans)
}

private fun dijkstra(s: Int): Array<Int>{
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = Array(n + 1){ Int.MAX_VALUE }

    q.offer(s to 0)
    dist[s] = 0

    while (q.isNotEmpty()){
        val (cNode, cCost) = q.poll()

        if(cCost > dist[cNode]) continue

        graph[cNode].forEach {
            val nCost = it.second + cCost
            val nNode = it.first

            if(dist[nNode] > nCost){
                q.offer(nNode to nCost)
                dist[nNode] = nCost
            }
        }
    }

    return dist
}