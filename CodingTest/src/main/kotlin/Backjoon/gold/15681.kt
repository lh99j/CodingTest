import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var visited: Array<Int>
private lateinit var dp: Array<Int>

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, r, q) = br.readLine().split(" ").map{ it.toInt() }
    var sb = StringBuilder()

    var tree = Array<MutableList<Int>>(n + 1){ mutableListOf() }
    visited = Array(n + 1){ 0 }
    dp = Array(n + 1){ 1 }

    tree[0].add(0)

    repeat(n - 1){
        val (node1, node2) = br.readLine().split(" ").map { it.toInt() }

        tree[node1].add(node2)
        tree[node2].add(node1)
    }

    dfs(tree, r)

    repeat(q){
        var query = br.readLine().toInt()

        sb.append(dp[query]).append("\n")
    }

    println(sb)
}

private fun dfs(tree: Array<MutableList<Int>>, node: Int){
    visited[node] = 1

    tree[node].forEach {
        if(visited[it] != 1){
            dfs(tree, it)
            dp[node] += dp[it]
        }
    }
}