import java.util.*

class Network {
    private lateinit var visited: Array<Int>

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        visited = Array(n + 1) { 0 }
        var adj = Array<MutableList<Int>>(n + 1) { mutableListOf() }

        adj[0].add(0)

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (computers[i][j] == 1) {
                    adj[i + 1].add(j + 1)
                    adj[j + 1].add(i + 1)
                }
            }
        }

        for (i in 1 until n + 1) {
            if (visited[i] == 0) {
                bfs(adj, i)
                answer++
            }
        }

        return answer - 1
    }

    fun bfs(adj: Array<MutableList<Int>>, node: Int) {
        val q: Queue<Int> = LinkedList()

        q.offer(node)
        visited[node] = 1
        while (q.isNotEmpty()) {
            val temp = q.poll()

            adj[temp].forEach {
                if (visited[it] == 0) {
                    q.offer(it)
                    visited[it] = 1
                }
            }
        }
        
    }
}

fun main() {
    val n = Network()
}