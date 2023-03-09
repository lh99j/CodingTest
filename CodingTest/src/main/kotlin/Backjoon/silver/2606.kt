import java.io.*
import java.util.*

private var visited = mutableListOf<Int>()
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var num = br.readLine().toInt()
    var count = br.readLine().toInt()
    var dfsMat = Array<MutableList<Int>>(num) { mutableListOf() }

    for (i in 1..count) {
        var (u, v) = br.readLine().split(" ").map { it.toInt() - 1 }
        dfsMat[u].add(v)
        dfsMat[v].add(u)
    }

    visited = MutableList<Int>(num) { 0 }
    dfs(dfsMat, 0)

    var answer = -1

    visited.forEach {
        if(it == 1)
            answer++
    }

     println(answer)
}

private fun dfs(mat: Array<MutableList<Int>>, r: Int) {
    visited[r] = 1

    mat[r].forEach {
        if(visited[it] == 0)
            dfs(mat, it)
    }
}