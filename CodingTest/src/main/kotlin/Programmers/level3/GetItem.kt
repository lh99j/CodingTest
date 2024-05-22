import java.util.*

private const val MAX_SIZE = 102
class GetItem {
    private var validXY = Array(MAX_SIZE) { Array(MAX_SIZE) { 0 } }
    private var dx = intArrayOf(0, 1, -1, 0)
    private var dy = intArrayOf(1, 0, 0, -1)

    fun solution(rectangle: Array<IntArray>, characterX: Int, characterY: Int, itemX: Int, itemY: Int): Int {
        rectangle.forEach {
            make(it[0] * 2, it[1] * 2, it[2] * 2, it[3] * 2)
        }

        for(i in 0 until MAX_SIZE){
            for(j in 0 until MAX_SIZE){
                if(validXY[i][j] == 0)
                    continue

                for(k in 0..2){
                    for(p in 0..2){
                        if(validXY[i + k - 1][j + p - 1] == 0){
                            validXY[i][j] = 2
                        }
                    }
                }
            }
        }

        return bfs(characterX * 2 to characterY * 2, itemX * 2 to itemY * 2)
    }


    private fun make(x: Int, y: Int, a: Int, b: Int) {
        for (i in x..a) {
            for (j in y..b) {
                validXY[i][j] = 1
            }
        }
    }

    private fun bfs(s: Pair<Int, Int>, d: Pair<Int, Int>): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        var visited = Array(MAX_SIZE) { Array(MAX_SIZE) { -1 } }

        visited[s.first][s.second] = 0
        q.offer(s)

        while (q.isNotEmpty()) {
            val (x, y) = q.poll()

            for(i in 0..3){
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(nx in 0 until MAX_SIZE && ny in 0 until MAX_SIZE && visited[nx][ny] == -1 && validXY[nx][ny] == 2){
                    q.offer(nx to ny)
                    visited[nx][ny] = visited[x][y] + 1
                }
            }

        }

        return visited[d.first][d.second] / 2
    }
}

fun main() {
    val gi = GetItem()
    println(
        gi.solution(
            arrayOf(
                intArrayOf(2, 2, 5, 5),
                intArrayOf(1, 3, 6, 4),
                intArrayOf(3, 1, 4, 6)
            ), 1, 4, 6, 3
        )
    )
}