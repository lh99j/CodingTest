import java.io.BufferedReader
import java.io.InputStreamReader

private const val INF = Int.MAX_VALUE / 2

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(v) { Array(v) { INF } }

    repeat(e) {
        val (start, end, value) = br.readLine().split(" ").map { it.toInt() }
        graph[start - 1][end - 1] = value
    }

    for (k in 0 until v) {
        for (i in 0 until v) {
            for (j in 0 until v) {
                if (i == j) {
                    continue
                }

                graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    var ans = INF

    for (i in 0 until v) {
        for (j in 0 until v) {
            if (i == j || graph[i][j] == INF || graph[j][i] == INF) {
                continue
            }

            ans = minOf(ans, graph[i][j] + graph[j][i])

        }
    }

    println(if (ans == INF) -1 else ans)
}