import java.io.*
import java.util.*

private var board = Array(501) { IntArray(501) { 0 } }
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private const val INF = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()) {
        val inputs = br.readLine().split(" ").map { it.toInt() }
        masking(inputs[0], inputs[1], inputs[2], inputs[3], 1)
    }

    repeat(br.readLine().toInt()) {
        val inputs = br.readLine().split(" ").map { it.toInt() }
        masking(inputs[0], inputs[1], inputs[2], inputs[3], 2)
    }

    val ans = bfs()

    println(if(ans == INF) -1 else ans)
}

private fun masking(x1: Int, y1: Int, x2: Int, y2: Int, v: Int) {
    val minX = minOf(x1, x2)
    val maxX = maxOf(x1, x2)
    val minY = minOf(y1, y2)
    val maxY = maxOf(y1, y2)

    for (x in minX..maxX) {
        for (y in minY..maxY) {
            board[x][y] = v
        }
    }
}

private fun bfs(): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(501) { Array(501) { Pair(0, INF) } }

    q.offer(0 to 0)
    visited[0][0] = Pair(0, 0)

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (check(nx, ny) && board[nx][ny] != 2) {
                // visited
                if (visited[nx][ny].second == INF) {
                    visited[nx][ny] = Pair(visited[x][y].first + 1, visited[x][y].second + board[nx][ny])
                    q.offer(nx to ny)
                } else if (visited[nx][ny].second > visited[x][y].second + board[nx][ny]) { // !visited
                    q.offer(nx to ny)
                    visited[nx][ny] = Pair(visited[x][y].first + 1, visited[x][y].second + board[nx][ny])
                }
            }
        }
    }

    return visited[500][500].second
}

private fun check(x: Int, y: Int) = x in 0 until 501 && y in 0 until 501
