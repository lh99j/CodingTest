import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var N = 0
private var M = 0
private lateinit var map: Array<MutableList<Int>>
private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)
private var ans = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var s = 0 to 0
    var sl = 3

    N = n
    M = m

    map = Array(n) { mutableListOf() }

    repeat(n) { idx ->
        val str = br.readLine()

        for (i in str.indices) {
            //이동 가능한 길
            if (str[i] == '.') {
                map[idx].add(0)
                //민식쨩이 서있는 위치
            } else if (str[i] == 'S') {
                map[idx].add(2)
                s = idx to i
                //이동 불가능한 위치
            } else if (str[i] == '#') {
                map[idx].add(1)
                //택배 배당해야하는 위치
            } else {
                map[idx].add(sl++)
            }
        }
    }

    bfs(s)
    println(ans)
}

private fun bfs(s: Pair<Int, Int>) {
    data class MN(val x: Int, val y: Int, val v: Int, val d: Int, val f1: Int, val f2: Int)

    var visited = Array(N) { Array(M) { Array(4) { Array(2) { Array(2) { false } } } } }
    val q: Queue<MN> = LinkedList()

    q.offer(MN(s.first, s.second, 0, -1, 0, 0))
    visited[s.first][s.second][3][0][0] = true

    while (q.isNotEmpty()) {
        var (x, y, v, d, f1, f2) = q.poll()

        if (f1 == 1 && f2 == 1) {
            ans = v
            return
        }

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            var nf1 = f1
            var nf2 = f2

            if (d != i && nx in 0 until N && ny in 0 until M && map[nx][ny] != 1 && !visited[nx][ny][i][f1][f2]) {
                if (map[nx][ny] == 3) {
                    nf1 = 1
                }
                if (map[nx][ny] == 4) {
                    nf2 = 1
                }

                visited[nx][ny][i][f1][f2] = true
                q.offer(MN(nx, ny, v + 1, i, nf1, nf2))

            }
        }
    }
}