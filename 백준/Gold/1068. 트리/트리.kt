private lateinit var visited: BooleanArray
private var ans = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nodes = br.readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(n) { false }
    val remove = br.readLine().toInt()
    var root = -1

    val graph = Array(n) { mutableListOf<Int>() }
    nodes.forEachIndexed { idx, value ->
        if (value != -1) {
            graph[value].add(idx)
        } else {
            root = idx
        }
    }

    dfs(root, remove, graph)
    println(ans)

}

private fun dfs(cur: Int, remove: Int, graph: Array<MutableList<Int>>) {
    if (cur == remove) {
        return
    }

    if(graph[cur].isEmpty() || (graph[cur].size == 1 && graph[cur].contains(remove))) {
        ans++
    }

    graph[cur].forEach {
        if (!visited[it]) {
            visited[it] = true
            dfs(it, remove, graph)
        }
    }
}
