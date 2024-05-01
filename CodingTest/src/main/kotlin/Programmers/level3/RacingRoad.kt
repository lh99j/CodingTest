import java.util.*

class RacingRoad {
    //0, 2 : 가로 1, 4: 세로
    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)
    private val r = intArrayOf(0, 2)
    private val c = intArrayOf(1, 4)

    fun solution(board: Array<IntArray>): Int {
        data class Car(val x: Int, val y: Int, val cost: Int, val d: Int)

        //직선 1, 곡선 2
        var visited = Array(board.size) { Array(board.size) { Array(4) { Int.MAX_VALUE } } }
        val q: Queue<Car> = LinkedList()
        q.offer(Car(0, 0, 0, -1))

        while (q.isNotEmpty()) {
            val (x, y, c, d) = q.poll()

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                val next = if (d == i || d == -1) {
                    c + 100
                } else {
                    c + 600
                }

                if (nx in board.indices && ny in board.indices && board[nx][ny] == 0 && visited[nx][ny][i] >= next) {
                    q.offer(Car(nx, ny, next, i))
                    visited[nx][ny][i] = next
                }

            }
        }

        return visited[board.size - 1][board.size - 1].min()
    }
}

fun main() {
    val rr = RacingRoad()
    println(
        rr.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 1, 0, 1),
                intArrayOf(1, 0, 0, 0)
            )
        )
    )
}