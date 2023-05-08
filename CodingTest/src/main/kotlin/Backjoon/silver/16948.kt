import java.io.*
import java.lang.Math.*
import java.util.*

private val dx = intArrayOf(-2, -2, 0, 0, 2, 2)
private val dy = intArrayOf(-1, 1, -2, 2, -1, 1)

fun main(args:Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val (r1, c1, r2, c2) = br.readLine().split(" ").map { it.toInt() }

    println(bfs(size, r1, c1, r2, c2))
}

private fun bfs(size: Int, r1: Int, c1: Int, r2: Int, c2: Int): Int{
    var q: Queue<Dot> = LinkedList()
    var visited = Array(size){Array(size){ 200 } }

    q.offer(Dot(r1, c1))
    visited[r1][c1] = 0

    while(q.isNotEmpty()){
        val temp = q.poll()

        for(i in dx.indices){
            val nx = temp.x + dx[i]
            val ny = temp.y + dy[i]

            if(nx in 0 until size && ny in 0 until size && visited[nx][ny] == 200){
                visited[nx][ny] = min(visited[temp.x][temp.y] + 1, visited[nx][ny])
                q.offer(Dot(nx, ny))
            }

            if(nx == r2 && ny == c2){
                return visited[nx][ny]
            }

        }
    }

    return -1
}