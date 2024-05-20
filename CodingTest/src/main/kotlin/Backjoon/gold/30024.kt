import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.PriorityQueue

private data class Corn30024(val x: Int, val y: Int, val value: Int)

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)
private val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    var corns = Array<MutableList<Int>>(N) { mutableListOf() }
    val pq: PriorityQueue<Corn30024> = PriorityQueue(compareByDescending { it.value })
    val visited = Array(N) { Array(M) { false } }

    repeat(N) { idx ->
        val inputs = br.readLine().split(" ").map { it.toInt() }
        corns[idx].addAll(inputs)
    }

    var K = br.readLine().toInt()

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                pq.offer(Corn30024(i, j, corns[i][j]))
                visited[i][j] = true
            }
        }
    }

    while (K > 0) {
        val p = pq.poll()
        visited[p.x][p.y] = true
        sb.append("${p.x + 1} ${p.y + 1}").append("\n")

        for (i in 0..3) {
            val nx = p.x + dx[i]
            val ny = p.y + dy[i]

            if (nx in 0 until N && ny in 0 until M && !visited[nx][ny]) {
                pq.offer(Corn30024(nx, ny, corns[nx][ny]))
                visited[nx][ny] = true
            }
        }

        K--
    }

    println(sb)
}