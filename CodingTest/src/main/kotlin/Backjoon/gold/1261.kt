import java.io.*
import java.util.*

private lateinit var maze: Array<MutableList<Int>>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var N = 0
private var M = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    M = m
    N = n

    maze = Array(N) { mutableListOf() }

    repeat(N) { idx ->
        val inputs = br.readLine().chunked(1).map { it.toInt() }
        maze[idx].addAll(inputs)
    }

    println(bfs())
}

private fun bfs(): Int {
    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
    val visited = Array(N) { BooleanArray(M) { false } }

    pq.offer(Triple(0, 0, 0))
    visited[0][0] = true

    while (pq.isNotEmpty()) {
        val (x, y, cnt) = pq.poll()

        if(x == N - 1 && y == M - 1){
            return cnt
        }

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (validPosition(nx, ny) && !visited[nx][ny]) {
                if(maze[nx][ny] == 0){
                    pq.offer(Triple(nx, ny, cnt))
                }else{
                    pq.offer(Triple(nx, ny, cnt + 1))
                }

                visited[nx][ny] = true
            }
        }
    }

    return -1
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until M