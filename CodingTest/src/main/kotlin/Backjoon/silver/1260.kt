import java.io.*
import java.util.*

private var visited = mutableListOf<Int>()
private var total = 0

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    var mat = Array<MutableList<Int>>(n) { mutableListOf() }
    total = n

    repeat(m) {
        var (u, v) = br.readLine().split(" ").map { it.toInt() - 1 }
        mat[u].add(v)
        mat[v].add(u)
    }

    mat.forEach {
        it.sort()
    }

    visited = MutableList<Int>(n) { 0 }
    dfs(mat, v - 1)

    println()

    visited.clear()
    visited = MutableList<Int>(n) { 0 }
    bfs(mat, v - 1)
}

private fun dfs(mat: Array<MutableList<Int>>, r: Int) {
    visited[r] = 1
    print("${r + 1} ")
    mat[r].forEach {
        if (visited[it] == 0)
            dfs(mat, it)
    }
}

private fun bfs(mat: Array<MutableList<Int>>, r: Int) {
    var q: Queue<Int> = LinkedList<Int>()
    q.clear()
    visited[r] = 1
    print("${r + 1} ")
    q.offer(r)

    while (q.isNotEmpty()) {
        var temp = q.poll()
        mat[temp].forEach {
            if (visited[it] == 0) {
                q.offer(it)
                visited[it] = 1
                print("${it + 1} ")
            }
        }
    }

}