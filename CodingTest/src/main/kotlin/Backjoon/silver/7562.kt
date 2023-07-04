import java.util.*
import java.io.*
import java.lang.StringBuilder

private val dx = intArrayOf(-2, -1, -2, -1, 1, 2, 2, 1)
private val dy = intArrayOf(-1, -2, 1, 2, -2, -1, 1, 2)

//private data class Dot(var x: Int, var y: Int)

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    repeat(br.readLine().toInt()){
        val mapSize = br.readLine().toInt()
        val (x1, y1) = br.readLine().split(" ").map { it.toInt() }
        val (x2, y2) = br.readLine().split(" ").map { it.toInt() }

        sb.append(bfs(mapSize, x1, y1, x2, y2)).append("\n")
    }

    println(sb)
}

private fun bfs(size: Int, x1: Int, y1: Int, x2: Int, y2: Int): Int{
    var visited = Array(size){ Array(size) { -1 } }
    var q: Queue<Dot> = LinkedList()

    q.offer(Dot(x1, y1))
    visited[x1][y1] = 0

    if(x1 == x2 && y1 == y2){
        return 0
    }

    while(q.isNotEmpty()){
        val temp = q.poll()

        for(i in 0 until 8){
            val nx = temp.x + dx[i]
            val ny = temp.y + dy[i]

            if(nx in 0 until size && ny in 0 until size && visited[nx][ny] == -1){
                visited[nx][ny] = visited[temp.x][temp.y] + 1
                q.offer(Dot(nx, ny))
            }

            if(nx == x2 && ny == y2){
                return visited[nx][ny]
            }
        }
    }

    return -1
}
