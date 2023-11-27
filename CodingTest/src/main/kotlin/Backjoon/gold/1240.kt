import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private data class Dot1240(val node: Int, val distance: Int)
private val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (size, cnt) = br.readLine().split(" ").map { it.toInt() }
    val tree = Array<MutableList<Dot1240>>(size + 1) { mutableListOf() }
    tree[0].add(Dot1240(0, 0))

    repeat(size - 1) {
        val (start, end, distance) = br.readLine().split(" ").map { it.toInt() }
        tree[start].add(Dot1240(end, distance))
        tree[end].add(Dot1240(start, distance))
    }

    repeat(cnt) {
        val (start, end) = br.readLine().split(" ").map { it.toInt()}
        bfs(tree, start, end)
    }

    println(sb)
}

private fun bfs(tree: Array<MutableList<Dot1240>>, start: Int, find: Int) {
    val q: Queue<Int> = LinkedList()
    val visited = Array(tree.size + 1) { -1 }

    q.offer(start)
    visited[start] = 0

    while (q.isNotEmpty()) {
        val temp = q.poll()


        tree[temp].forEach {
            if (visited[it.node] == -1) {
                q.offer(it.node)
                visited[it.node] = visited[temp] + it.distance
            }


            if(it.node == find){
                sb.append(visited[it.node]).append("\n")
                return
            }
        }
    }
}