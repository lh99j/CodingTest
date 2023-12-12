import java.io.BufferedReader
import java.io.InputStreamReader

private var percent = mutableListOf<Double>()
private var size = 0
private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)
private var sum = 0.0
private var visited = Array(30) { Array(30) { false } }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    size = input[0]
    for (i in 1 until input.size) {
        percent.add(input[i].toDouble() / 100)
    }

    visited[15][15] = true
    per(0, 15, 15, 1.0)
    println(sum)
}

private fun per(cnt: Int, cx: Int, cy: Int, pp: Double) {
    if (cnt == size) {
        sum += pp
        return
    }

    for (i in 0..3) {
        if (percent[i] != 0.0) {
            var x = cx
            var y = cy

            x += dx[i]
            y += dy[i]

            if (!visited[x][y]) {
                visited[x][y] = true
                per(cnt + 1, x, y, percent[i] * pp)
                visited[x][y] = false
            }
        }
    }
}