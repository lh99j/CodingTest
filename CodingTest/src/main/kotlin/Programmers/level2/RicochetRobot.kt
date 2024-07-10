import java.util.*

class RicochetRobot {
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)
    private lateinit var board: Array<String>
    private var s = 0 to 0
    private var d = 0 to 0

    fun solution(b: Array<String>): Int {
        board = b
        for (i in board.indices) {
            for (j in 0 until board[i].length) {
                if (board[i][j] == 'R') s = i to j
                if (board[i][j] == 'G') d = i to j
            }
        }

        return bfs(s, d)
    }


    private fun bfs(s: Pair<Int, Int>, d: Pair<Int, Int>): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(board.size) { IntArray(board[0].length) { -1 } }

        q.offer(s)
        visited[s.first][s.second] = 0

        while (q.isNotEmpty()) {
            val (x, y) = q.poll()

            if (x to y == d) {
                return visited[x][y]
            }

            for (i in 0..3) {
                val (nx, ny) = getNextPosition(x, y, i)

                if (visited[nx][ny] == -1) {
                    q.offer(nx to ny)
                    visited[nx][ny] = visited[x][y] + 1
                }
            }
        }

        return -1
    }

    private fun getNextPosition(x: Int, y: Int, d: Int): Pair<Int, Int> {
        var cx = x
        var cy = y

        while (validPosition(cx + dx[d], cy + dy[d]) && board[cx + dx[d]][cy + dy[d]] != 'D') {
            cx += dx[d]
            cy += dy[d]
        }

        return cx to cy
    }

    private fun validPosition(x: Int, y: Int) = x in board.indices && y in 0 until board[0].length
}