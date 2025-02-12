import java.util.*

private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    var testCase = 1

    while (true) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        var ans = 0
        if (n == 0 && m == 0)
            break

        graph = Array(n + 1) { mutableListOf<Int>() }
        visited = BooleanArray(n + 1) { false }

        repeat(m) {
            val (start, end) = br.readLine().split(" ").map { it.toInt() }
            graph[start].add(end)
            graph[end].add(start)
        }

        for (i in 1..n) {
            if (!visited[i] && isTree(i)) {
                ans++
            }
        }

        val out = if (ans == 0) "No trees." else if (ans == 1) "There is one tree." else "A forest of $ans trees."
        sb.append("Case ${testCase}: $out").append("\n")

        testCase++
    }

    println(sb)
}

private fun isTree(start: Int): Boolean {
    val q: Queue<Pair<Int, Int>> = LinkedList()

    q.offer(start to 0)
    visited[start] = true

    while (q.isNotEmpty()) {
        val (cur, pre) = q.poll()

        graph[cur].forEach { next ->
            if (!visited[next]) {
                q.offer(next to cur)
                visited[next] = true
            } else if (next != pre) {
                return false
            }
        }
    }

    return true
}