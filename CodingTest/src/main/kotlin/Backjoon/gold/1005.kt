import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

private val sb = StringBuilder()
private lateinit var dp: Array<Int>
private lateinit var visited: Array<Boolean>
val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val cnt = br.readLine().toInt()

    repeat(cnt) {
        cycle()
    }
    println(sb)
}

private fun cycle() {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val times = br.readLine().split(" ").map { it.toInt() }
    val acm = Array<MutableList<Int>>(N + 1){ mutableListOf() }
    dp = Array(N + 1){ 0 }
    visited = Array(N + 1) { false }

    repeat(K){
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        acm[end].add(start)
    }

    val W = br.readLine().toInt()

    dfs(W, times, acm)

    sb.append(dp[W]).append("\n")
}

private fun dfs(start: Int, times: List<Int>, acm: Array<MutableList<Int>>){
    visited[start] = true
    dp[start] = times[start - 1]

    acm[start].forEach {
        if(!visited[it]){
            dfs(it, times, acm)
        }

        dp[start] = maxOf(dp[start], dp[it] + times[start - 1])
    }
}