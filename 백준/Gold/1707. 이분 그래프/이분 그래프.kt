import java.io.*
import java.util.*

private lateinit var visited: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    repeat(br.readLine().toInt()) {
        val (v, e) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(v + 1) { mutableListOf<Int>() }
        var isBinary = true
        visited = BooleanArray(v + 1) { false }

        graph[0].add(0)
        repeat(e) {
            val (start, end) = br.readLine().split(" ").map { it.toInt() }
            graph[start].add(end)
            graph[end].add(start)
        }

        for(i in 1..v){
            if(!visited[i] && !isBinaryGraph(graph, i)){
                isBinary = false
                break
            }
        }

        sb.append(if(isBinary) "YES" else "NO").append("\n")
    }

    println(sb)
}

private fun isBinaryGraph(graph: Array<MutableList<Int>>, start: Int): Boolean {
    val q: Queue<Int> = LinkedList()
    val check = IntArray(graph.size) { 0 }

    visited[start] = true
    q.offer(start)
    check[start] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()

        graph[cur].forEach { next ->
            if (!visited[next]) {
                q.offer(next)
                check[next] = getOppositeValue(check[cur])
                visited[next] = true
            } else if (check[next] == check[cur]) {
                return false
            }
        }
    }

    return true
}

private fun getOppositeValue(value: Int) = if (value == 1) 0 else 1
