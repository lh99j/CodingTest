import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var N = 0
private var M = 0
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private val s = Stack<Pair<Int, Int>>()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array<MutableList<Int>>(n) { mutableListOf() }
    var ans = 0
    N = n
    M = m

    repeat(n) { idx ->
        val inputs = br.readLine().split(" ").map { it.toInt() }
        board[idx].addAll(inputs)
    }

    while (board.any { it.contains(1) }) {
        bfs(board)
        melt(board)
        ans++
    }

    println(ans)
}

private fun bfs(board: Array<MutableList<Int>>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(N) { BooleanArray(M) { false } }
    var checkChess = Array(N) { Array(M) { 0 } }

    q.offer(0 to 0)
    visited[0][0] = true

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (!validPosition(nx, ny))
                continue

            if (visited[nx][ny])
                continue

            if (board[nx][ny] == 0) {
                q.offer(nx to ny)
                visited[nx][ny] = true
            }

            if (board[nx][ny] == 1 && checkChess[nx][ny] < 2) {
                checkChess[nx][ny]++

                if (checkChess[nx][ny] == 2) {
                    s.push(nx to ny)
                }
            }
        }
    }
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until M

private fun melt(board: Array<MutableList<Int>>) {
    while (s.isNotEmpty()) {
        val (x, y) = s.pop()

        board[x][y] = 0
    }
}