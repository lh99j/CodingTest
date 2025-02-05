import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var land: Array<CharArray>

data class Point2589(val x: Int, val y: Int, val value: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var ans = -1
    land = Array(n) { CharArray(m) }

    repeat(n) { i ->
        br.readLine().forEachIndexed { j, c ->
            land[i][j] = c
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (land[i][j] == 'L') {
                val distance = getDistance(i, j)
                ans = maxOf(distance, ans)
            }
        }
    }

    println(ans)
}

private fun getDistance(x: Int, y: Int): Int {
    val q: Queue<Point2589> = LinkedList()
    val visited = Array(land.size) { BooleanArray(land[0].size) { false } }
    var result = -1

    visited[x][y] = true
    q.offer(Point2589(x, y, 0))

    while (q.isNotEmpty()) {
        val (cx, cy, cv) = q.poll()
        result = cv

        for (i in 0..3) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (isValidPoint(nx, ny) && land[nx][ny] == 'L' && !visited[nx][ny]) {
                q.offer(Point2589(nx, ny, cv + 1))
                visited[nx][ny] = true
            }
        }
    }

    return result
}

private fun isValidPoint(x: Int, y: Int) = x in 0 until land.size && y in 0 until land[0].size

