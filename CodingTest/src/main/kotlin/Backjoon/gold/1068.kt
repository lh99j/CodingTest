import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet
import kotlin.system.exitProcess

private var ans = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val nodes = br.readLine().split(" ").map { it.toInt() }
    var root = -1
    val removeAt = br.readLine().toInt()
    val tree = Array<MutableList<Int>>(size) { mutableListOf() }

    for (i in nodes.indices) {
        if (nodes[i] == -1)
            root = i
        else {
            tree[nodes[i]].add(i)
        }
    }

    bfs(tree, removeAt, root)
    println(ans)
}

private fun bfs(tree: Array<MutableList<Int>>, removeAt: Int, root: Int) {
    if (removeAt == root) {
        println("0")
        exitProcess(0)
    }
    val q: Queue<Int> = LinkedList()
    val visited = HashSet<Int>()

    q.offer(root)
    visited.add(root)

    while (q.isNotEmpty()) {
        val temp = q.poll()

        if (tree[temp].isEmpty() || (tree[temp].size == 1 && tree[temp].single() == removeAt)) {
            ans++
        }

        tree[temp].forEach {
            if (it !in visited && it != removeAt) {
                q.offer(it)
                visited.add(it)
            }
        }
    }
}