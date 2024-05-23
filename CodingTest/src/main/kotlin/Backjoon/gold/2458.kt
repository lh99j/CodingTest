import java.io.BufferedReader
import java.io.InputStreamReader

private const val INF = 502
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    var floyd = Array(N + 1) { Array(N + 1) { INF } }
    var ans = 0

    repeat(N + 1) { idx ->
        floyd[idx][idx] = 0
    }

    repeat(M) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        floyd[start][end] = 1
    }

    for (k in 1 until N + 1) {
        for (i in 1 until N + 1) {
            for (j in 1 until N + 1) {
                if (floyd[i][j] > floyd[i][k] + floyd[k][j])
                    floyd[i][j] = floyd[i][k] + floyd[k][j]
            }
        }
    }

    for (i in 1 until N + 1) {
        var cnt = 0

        for (j in 1 until N + 1) {
            if (floyd[i][j] != INF || floyd[j][i] != INF) {
                cnt++
            }
        }

        if (cnt == N) {
            ans++
        }
    }

    println(ans)
}