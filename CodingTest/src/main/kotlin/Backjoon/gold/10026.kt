import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var board: Array<MutableList<String>>
private lateinit var blindBoard: Array<MutableList<String>>
private lateinit var visited: Array<Array<Boolean>>
private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)
private var size = 0
private var normal = 0
private var blind = 0

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    size = br.readLine().toInt()

    board = Array(size){ mutableListOf() }
    blindBoard = Array(size){ mutableListOf() }
    visited = Array(size){Array(size) { false } }

    repeat(size){ idx ->
        var inputs = br.readLine().chunked(1).toMutableList()
        board[idx].addAll(inputs)

        for(i in 0 until size){
            if(inputs[i] == "G"){
                inputs[i] = "R"
            }
        }

        blindBoard[idx].addAll(inputs)
    }

    for(i in 0 until size){
        for(j in 0 until size){
            if(!visited[i][j]){
                bfs(i, j)
            }
        }
    }

    visited = Array(size){Array(size) { false } }

    for(i in 0 until size){
        for(j in 0 until size){
            if(!visited[i][j]){
                blindBfs(i, j)
            }
        }
    }

    println("$normal $blind")

}

private fun bfs(i: Int, j: Int){
    val color = board[i][j]

    val q: Queue<Pair<Int, Int>> = LinkedList()
    visited[i][j] = true
    q.offer(i to j)

    while (q.isNotEmpty()){
        val (x, y) = q.poll()

        for(i in 0..3){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until size && ny in 0 until size && !visited[nx][ny] && board[nx][ny] == color){
                q.offer(nx to ny)
                visited[nx][ny] = true
            }
        }
    }

    normal++
}

private fun blindBfs(i: Int, j: Int){
    val color = blindBoard[i][j]

    val q: Queue<Pair<Int, Int>> = LinkedList()
    visited[i][j] = true
    q.offer(i to j)

    while (q.isNotEmpty()){
        val (x, y) = q.poll()

        for(i in 0..3){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until size && ny in 0 until size && !visited[nx][ny] && blindBoard[nx][ny] == color){
                q.offer(nx to ny)
                visited[nx][ny] = true
            }
        }
    }

    blind++
}