import java.io.*
import java.util.*

private lateinit var visited: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    repeat(br.readLine().toInt()) {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(N + 1) { mutableListOf<Int>() }
        var ans = true
        visited = IntArray(N + 1) { -1 }

        graph[0].add(0)

        repeat(M) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }

            graph[x].add(y)
            graph[y].add(x)
        }

        for (i in 1..N) {
            if (visited[i] == -1 && !bfs(graph, i)) {
                ans = false
                break

            }
        }

        sb.append(if(ans) "possible" else "impossible").append("\n")
    }

    println(sb)
}

private fun bfs(graph: Array<MutableList<Int>>, start: Int): Boolean {
    val q: Queue<Int> = LinkedList()

    q.offer(start)
    visited[start] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()

        graph[cur].forEach { next ->
            if (visited[next] == -1) {
                visited[next] = getDifferentColor(visited[cur])
                q.offer(next)
            } else if (visited[next] == visited[cur]) {
                return false
            }
        }
    }

    return true
}

private fun getDifferentColor(color: Int): Int {
    return if (color == 0) {
        1
    } else {
        0
    }
}
