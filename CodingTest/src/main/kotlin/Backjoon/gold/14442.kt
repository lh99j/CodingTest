import java.util.*
import java.io.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private data class Dot14442(var w: Int, var x: Int, var y: Int)

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    var map = Array<MutableList<Int>>(n) { mutableListOf() }

    for (i in 0 until n) {
        val tempNum = br.readLine().toString()

        tempNum.forEach {
            map[i].add(it.digitToInt())
        }
    }

    if(map.size == 1){
        println(1)
    }else{
        println(bfs(map, k))
    }
}

private fun bfs(map: Array<MutableList<Int>>, count: Int): Int{
    var q: Queue<Dot14442> = LinkedList<Dot14442>()
    var visited = Array(count + 1) { Array(map.size) { Array(map[0].size) { 0 } } }
    visited[0][0][0] = 1

    q.offer(Dot14442(0, 0, 0))

    while (q.isNotEmpty()) {
        val temp = q.poll()

        for (i in 0 until 4) {
            val nx = temp.x + dx[i]
            val ny = temp.y + dy[i]

            if(nx == map.size -1 && ny == map[0].size - 1){
                return visited[temp.w][temp.x][temp.y] + 1
            }

            if (nx in 0 until map.size && ny in 0 until map[0].size && visited[temp.w][nx][ny] == 0) {
                if(map[nx][ny] == 0){
                    visited[temp.w][nx][ny] = visited[temp.w][temp.x][temp.y] + 1
                    q.offer(Dot14442(temp.w, nx, ny))
                }else if(map[nx][ny] == 1 && temp.w < count && visited[temp.w + 1][nx][ny] == 0){
                    visited[temp.w + 1][nx][ny] = visited[temp.w][temp.x][temp.y] + 1
                    q.offer(Dot14442(temp.w + 1, nx, ny))
                }
            }

        }

    }
    return -1
}