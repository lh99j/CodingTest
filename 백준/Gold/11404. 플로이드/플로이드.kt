private const val INF = 1_000_000_001

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val graph = Array(n) { IntArray(n) { INF } }

    for(i in 0 until n){
        graph[i][i] = 0
    }

    repeat(m) {
        val (start, end, value) = br.readLine().split(" ").map { it.toInt() }
        graph[start - 1][end - 1] = minOf(graph[start - 1][end - 1], value)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][j] > graph[i][k] + graph[k][j]) {
                    graph[i][j] = graph[i][k] + graph[k][j]
                }
            }
        }
    }

    for(i in 0 until n){
        for(j in 0 until n){
            print("${if(graph[i][j] != INF) graph[i][j] else 0} ")
        }
        println()
    }
}
