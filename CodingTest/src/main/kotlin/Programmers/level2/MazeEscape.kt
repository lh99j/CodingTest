import java.util.*

class MazeEscape {
    private lateinit var map: Array<String>
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)

    fun solution(maps: Array<String>): Int {
        var start = 0 to 0
        var end = 0 to 0
        var lever = 0 to 0

        map = maps

        for(i in maps.indices){
            for(j in 0 until map[0].length){
                if(maps[i][j] == 'S'){
                    start = i to j
                }

                if(map[i][j] == 'E'){
                    end = i to j
                }

                if(map[i][j] == 'L'){
                    lever = i to j
                }
            }
        }


        val l = bfs(start, lever)
        if(l == -1) return -1

        val e = bfs(lever, end)
        if(e == -1) return -1

        return l + e
    }

    private fun bfs(s: Pair<Int, Int>, d: Pair<Int, Int>): Int{
        val q: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(map.size){ IntArray(map[0].length) { -1 } }

        q.offer(s)
        visited[s.first][s.second] = 0

        while(q.isNotEmpty()){
            val (x, y) = q.poll()


            if(x == d.first && y == d.second){
                return visited[x][y]
            }

            for(i in 0..3){
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(validPosition(nx, ny) && visited[nx][ny] == -1 && map[nx][ny] != 'X'){
                    q.offer(nx to ny)
                    visited[nx][ny] = visited[x][y] + 1
                }
            }
        }

        return -1
    }

    private fun validPosition(x: Int, y: Int) = x in map.indices && y in 0 until map[0].length
}