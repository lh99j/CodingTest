import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var board: Array<MutableList<Int>>
private val s = Stack<Pair<Int, Int>>()
private var N = 0
private var M = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    var ans = 0
    var cnt = 0
    board = Array(N) { mutableListOf() }

    repeat(n) { idx ->
        val inputs = br.readLine().split(" ").map { it.toInt() }
        board[idx].addAll(inputs)
    }

    while (board.any { it.contains(1) }) {
        bfs()
        cnt = s.size
        melt()
        ans++
    }

    println(ans)
    println(cnt)
}

private fun valid(x: Int, y: Int) = x in 0 until N && y in 0 until M

private fun bfs(){
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(N){BooleanArray(M) { false } }

    q.offer(Pair(0, 0))
    visited[0][0] = true

    while (q.isNotEmpty()){
        val (x, y) = q.poll()

        for(i in 0..3){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(!valid(nx, ny)){
                continue
            }

            if(visited[nx][ny]){
                continue
            }

            if(board[nx][ny] == 0){
                q.offer(nx to ny)
                visited[nx][ny] = true
            }

            if(board[nx][ny] == 1){
                s.push(nx to ny)
                visited[nx][ny] = true
            }
        }
    }
}

private fun melt(){
    while (s.isNotEmpty()){
        val (x, y) = s.pop()
        board[x][y] = 0
    }
}