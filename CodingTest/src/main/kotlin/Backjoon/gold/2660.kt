import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val tree = Array<MutableList<Int>>(size + 1) { mutableListOf() }
    tree[0].add(0)

    while (true) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        if (start == -1 && end == -1) {
            break
        }
        tree[start].add(end)
        tree[end].add(start)
    }

    var ans = mutableListOf<Int>()

    for (i in 1..size) {
        ans.add(bfs(tree, i))
    }

    println("${ans.min()} ${ans.count { it == ans.min() }}")
    var minAns = ans.withIndex().filter { it.value == ans.min() }.map { it.index + 1 }
    println(minAns.joinToString(" "))
}

private fun bfs(tree: Array<MutableList<Int>>, start: Int): Int {
    val q: Queue<Int> = LinkedList()
    val visited = Array(tree.size) { 0 }

    q.offer(start)
    visited[start] = 1

    while (q.isNotEmpty()) {
        val temp = q.poll()

        tree[temp].forEach {
            if (visited[it] == 0) {
                q.offer(it)
                visited[it] = visited[temp] + 1
            }
        }
    }

    return visited.max() - 1
}