import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
//private data class Dot(val x: Int, val y: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    var maze = Array<MutableList<Int>>(size) { mutableListOf() }

    repeat(size) { index ->
        val arr = br.readLine().map { it.digitToInt() }
        maze[index].addAll(arr)
    }

    println(bfs(maze))
}

private fun bfs(maze: Array<MutableList<Int>>): Int {
    val q: Queue<Dot> = LinkedList()
    val visited = Array(maze.size) { Array(maze.size) { Dot(0, 0) } } //x : true, false, y : break cnt


    q.offer(Dot(0, 0))
    visited[0][0] = Dot(1, 0)

    while(q.isNotEmpty()){
        val (x, y) = q.poll()

        for(i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in maze.indices && ny in maze.indices){
                if(visited[nx][ny].x == 0 && maze[nx][ny] == 1){
                    q.offer(Dot(nx, ny))
                    visited[nx][ny] = Dot(1, visited[x][y].y)
                }else if(visited[nx][ny].x == 0 && maze[nx][ny] == 0){
                    q.offer(Dot(nx, ny))
                    visited[nx][ny] = Dot(1, visited[x][y].y + 1)
                }

                if(visited[nx][ny].x == 1){
                    if(maze[nx][ny] == 1 && visited[nx][ny].y > visited[x][y].y){
                        q.offer(Dot(nx, ny))
                        visited[nx][ny] = Dot(1, visited[x][y].y)
                    }else if(maze[nx][ny] == 0 && visited[nx][ny].y > visited[x][y].y + 1){
                        q.offer(Dot(nx, ny))
                        visited[nx][ny] = Dot(1, visited[x][y].y + 1)
                    }
                }
            }
        }
    }


    return visited[maze.size - 1][maze.size - 1].y
}