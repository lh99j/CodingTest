import java.util.*

private lateinit var graph: Array<MutableList<Int>>
private lateinit var dist: IntArray
private const val INF = Int.MAX_VALUE

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    var ts = 1

    while (true) {
        val n = br.readLine().toInt()
        if(n == 0){
            break
        }
        graph = Array(n) { mutableListOf<Int>() }
        dist = IntArray(n * n) { INF }

        repeat(n) { idx ->
            val inputs = br.readLine().split(" ").map { it.toInt() }
            graph[idx].addAll(inputs)
        }

        val ans = dijkstra()
        sb.append("Problem ${ts}: $ans").append("\n")

        ts++
    }

    println(sb)
}

private fun dijkstra(): Int {
    val q = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })

    q.offer(Triple(0, 0, graph[0][0]))
    dist[getIdx(0, 0)]

    while (q.isNotEmpty()) {
        val (x, y, c) = q.poll()

        if(c > dist[getIdx(x, y)])
            continue

        for(i in 0..3){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(validPoint(nx, ny)){
                val nc = graph[nx][ny] + c
                if(nc < dist[getIdx(nx, ny)]){
                    q.offer(Triple(nx, ny, nc))
                    dist[getIdx(nx, ny)] = nc
                }
            }
        }
    }

    return dist[getIdx(graph.size - 1, graph.size - 1)]
}

private fun getIdx(x: Int, y: Int): Int = (x * graph.size) + y

private fun validPoint(x: Int, y: Int): Boolean = x in graph.indices && y in graph.indices