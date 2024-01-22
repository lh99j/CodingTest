import java.util.*

class GameMapShortestDistance {
    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    fun solution(maps: Array<IntArray>): Int {
        return bfs(maps)
    }

    private fun bfs(maps: Array<IntArray>): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        var visited = Array(maps.size) { Array(maps[0].size) { 0 } }
        q.offer(0 to 0)
        visited[0][0] = 1

        while (q.isNotEmpty()) {
            val (tx, ty) = q.poll()

            if (ty == maps.size && ty == maps[0].size) {
                return visited[tx][ty]
            }

            for (i in 0..3) {
                val nx = tx + dx[i]
                val ny = ty + dy[i]

                if (nx in maps.indices && ny in 0 until maps[0].size && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    q.offer(nx to ny)
                    visited[nx][ny] = visited[tx][ty] + 1
                }
            }
        }

        return -1
    }
}