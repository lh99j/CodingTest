private const val INF = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(n) { INF } }
    var ans = INF to INF

    for (i in 0 until n) {
        graph[i][i] = 0
    }

    repeat(m) {
        val (start, end, value) = br.readLine().split(" ").map { it.toInt() - 1 }
        graph[start][end] = value + 1
        graph[end][start] = value + 1
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][k] != INF && graph[k][j] != INF)
                    graph[i][j] = minOf(graph[i][k] + graph[k][j], graph[i][j])
            }
        }
    }

    for(i in 0 until n){
        var sum = 0
        for(j in 0 until n){
            sum += graph[i][j]
        }

        if(ans.second > sum){
            ans = i to sum
        }
    }

    println(ans.first + 1)
}
