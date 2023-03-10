import java.io.*
import java.util.*

private var dx = intArrayOf(0, -1, 0, 1)
private var dy = intArrayOf(1, 0, -1, 0)
private var N = 0
private var M = 0

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, m) = br.readLine().split(" ").map { it.toInt() }
//    var maze = Array<MutableList<Int>>(n){ mutableListOf() }
    N = n
    M = m
    var maze = Array(N) { Array(M) { 0 } }

    for (i in 0 until N) {
        var str = br.readLine().toString()

        for (j in 0 until M) {
            maze[i][j] = str[j].digitToInt()
        }
    }


    bfs(maze, N, M)

    // 배열 출력
//    for (i in 0 until maze.size) {
//        for (j in 0 until maze[0].size) {
//            print("${maze[i][j]} ")
//        }
//        println()
//    }

}

private fun bfs(mat: Array<Array<Int>>, x: Int, y: Int) {
    var q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    var visited = Array(x) { Array(y) { 0 } }
    var answer = 0

    visited[0][0] = 1
    q.offer(Pair(0, 0))

    while (q.isNotEmpty()) {
        var temp = q.poll()

        for (i in 0 until 4) {
            var tempX = temp.first + dx[i]
            var tempY = temp.second + dy[i]


            if (tempX !in 0 until x || tempY !in 0 until y || mat[tempX][tempY] == 0 || visited[tempX][tempY] != 0) {
                continue
            }

            visited[tempX][tempX] = 1
            q.offer(Pair(tempX, tempY))
            answer++

            if (tempX == x - 1 && tempY == y - 1) {
                println(answer)
                break
            }
        }
    }
}
