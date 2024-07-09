import java.util.*

class TripToIsland {
    private lateinit var visited: Array<BooleanArray>
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)

    fun solution(maps: Array<String>): List<Int> {
        var answer = mutableListOf<Int>()
        visited = Array(maps.size) { BooleanArray(maps[0].length) { false } }

        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {
                if (maps[i][j] != 'X' && !visited[i][j]) {
                    val value = bfs(i, j, maps)
                    answer.add(value)
                }
            }
        }

        return if (answer.isEmpty()) {
            listOf(-1)
        } else {
            answer.sorted()
        }
    }

    fun bfs(a: Int, b: Int, map: Array<String>): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        var cnt = 0

        visited[a][b] = true
        q.offer(a to b)
        cnt += map[a][b].toString().toInt()

        while (q.isNotEmpty()) {
            val (x, y) = q.poll()

            for (i in 0..3) {
                val nx = dx[i] + x
                val ny = dy[i] + y

                if (nx in map.indices && ny in 0 until map[0].length && map[nx][ny] != 'X' && !visited[nx][ny]) {
                    q.offer(nx to ny)
                    visited[nx][ny] = true
                    cnt += map[nx][ny].toString().toInt()
                }
            }
        }

        return cnt
    }
}