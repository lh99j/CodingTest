import java.io.*
import java.lang.Math.min
import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private const val MAX = 1_000_000

private data class Dot2206(var x: Int, var y: Int, var w: Int)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var map = Array<MutableList<Int>>(n) { mutableListOf() }

    for (i in 0 until n) {
        val tempNum = br.readLine().toString()

        tempNum.forEach {
            map[i].add(it.digitToInt())
        }
    }

//    map.forEach {
//        it.forEach{
//            print("$it ")
//        }
//        println()
//    }

    if(map.size == 1){
        println(1)
    }else{
        println(bfs(map))
    }
}

private fun bfs(map: Array<MutableList<Int>>): Int {
    var q: Queue<Dot2206> = LinkedList<Dot2206>()
    var visited = Array(map.size) { Array(map[0].size) { Array(2) { 0 } } }
    visited[0][0][0] = 1

    q.offer(Dot2206(0, 0, 0))

    while (q.isNotEmpty()) {
        val temp = q.poll()

        for (i in 0 until 4) {
            val nx = temp.x + dx[i]
            val ny = temp.y + dy[i]

            if(nx == map.size -1 && ny == map[0].size - 1){
                return visited[temp.x][temp.y][temp.w] + 1
            }

            if (nx in 0 until map.size && ny in 0 until map[0].size) {
                if(map[nx][ny] == 0 && visited[nx][ny][temp.w] == 0){
                    visited[nx][ny][temp.w] = visited[temp.x][temp.y][temp.w] + 1
                    q.offer(Dot2206(nx, ny, temp.w))
                }else if(map[nx][ny] == 1 && temp.w == 0){
                    visited[nx][ny][temp.w + 1] = visited[temp.x][temp.y][temp.w] + 1
                    q.offer(Dot2206(nx, ny, temp.w + 1))
                }
            }

        }

    }
    return -1
}