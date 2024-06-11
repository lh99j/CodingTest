import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var size = 0
private lateinit var map: Array<IntArray>
private var shark = 0 to 0 // 상어의 (x, y)
private var sharkInfo = 2 to 0 // 상어의 (level, 먹은 마리 수)
private val fishs: PriorityQueue<Triple<Int, Int, Int>> = PriorityQueue(compareBy { it.third })
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    size = st.nextToken().toInt()
    map = Array(size) { IntArray(size) { 0 } }

    repeat(size) { idx ->
        st = StringTokenizer(br.readLine())

        for (i in 0 until size) {
            val value = st.nextToken().toInt()

            if (value == 9) {
                shark = idx to i
            } else if (value > 0) {
                fishs.offer(Triple(idx, i, value))
            }

            map[idx][i] = value
        }
    }


    var ans = 0
    while (true) {
        var eatable = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })

        while (fishs.isNotEmpty() && fishs.peek().third < sharkInfo.first) {
            val p = fishs.poll()
            eatable.offer(Triple(p.first, p.second, bfs(p.first to p.second)))
        }

        if (eatable.isEmpty() || eatable.peek().third == 401) {
            break
        }

        var eat = Triple(0, 0, 0)

        if (eatable.size == 1) {
            eat = eatable.poll()
        } else {
            eat = eatable.poll()
            var check = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.first }, { it.second }))

            while(eatable.isNotEmpty() && eatable.peek().third == eat.third){
                check.offer(eatable.poll())
            }
            check.offer(eat)

            eat = check.poll()

            while (check.isNotEmpty()) {
                val p = check.poll()
                fishs.offer(Triple(p.first, p.second, map[p.first][p.second]))
            }

            while (eatable.isNotEmpty()){
                val p = eatable.poll()
                fishs.offer(Triple(p.first, p.second, map[p.first][p.second]))
            }
        }

        ans += eat.third
        map[eat.first][eat.second] = 9
        map[shark.first][shark.second] = 0
        shark = eat.first to eat.second

        var exp = sharkInfo.second + 1
        if (exp == sharkInfo.first) {
            sharkInfo = sharkInfo.first + 1 to 0
        } else {
            sharkInfo = sharkInfo.first to exp
        }

    }

    println(ans)
}

private fun bfs(d: Pair<Int, Int>): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(size) { IntArray(size) { -1 } }

    visited[shark.first][shark.second] = 0
    q.offer(shark.first to shark.second)

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        if (x == d.first && y == d.second) {
            return visited[x][y]
        }

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (validPosition(nx, ny) && visited[nx][ny] == -1 && map[nx][ny] <= sharkInfo.first) {
                q.offer(nx to ny)
                visited[nx][ny] = visited[x][y] + 1
            }
        }
    }

    return 401
}

private fun validPosition(x: Int, y: Int) = x in 0 until size && y in 0 until size