import java.io.*
import java.util.*

private var dx = intArrayOf(0, -1, 0, 1)
private var dy = intArrayOf(1, 0, -1, 0)

private data class Dot(var x: Int, var y: Int)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, m) = br.readLine().split(" ").map { it.toInt() }
//    var maze = Array<MutableList<Int>>(n){ mutableListOf() }

    var maze = Array(n) { Array(m) { 0 } }

    for (i in 0 until n) {
        var str = br.readLine().toString()

        for (j in 0 until m) {
            maze[i][j] = str[j].digitToInt()
        }
    }


    bfs(maze, n, m)

}

private fun bfs(mat: Array<Array<Int>>, x: Int, y: Int){
    var q: Queue<Dot> = LinkedList<Dot>()
    var visited = Array(x) { Array(y) { 1 } }

    visited[0][0] = 1
    q.add(Dot(0, 0))

    while (q.isNotEmpty()) {
        var temp = q.poll()

        for (i in 0 until 4) {
            var tempX = temp.x + dx[i]
            var tempY = temp.y + dy[i]


            if (tempX !in 0 until x  || tempY !in 0 until y || mat[tempX][tempY] == 0 || visited[tempX][tempY] != 1)
                continue

            q.add(Dot(tempX, tempY))
            visited[tempX][tempY] = visited[temp.x][temp.y] + 1

            if (tempX == x - 1 && tempY == y - 1) {
                println(visited[tempX][tempY])
                break
            }

        }
    }
}
