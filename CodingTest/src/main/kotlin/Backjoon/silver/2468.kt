import java.io.*
import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val size = br.readLine().toInt();
    var safeArea = Array<MutableList<Int>>(size) { mutableListOf() }
    var answerArr: MutableList<Int> = mutableListOf()

    for (i in 0 until size) {
        val numbers = br.readLine().split(" ").map { it.toInt() }
        safeArea[i].addAll(numbers)
    }

    var maxHeight = safeArea.toList().flatten().max()

    repeat(maxHeight) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                safeArea[i][j] -= 1
            }
        }
        answerArr.add(check(safeArea))
    }

    if(answerArr.max() == 0){
        println("1")
    }else{
        println(answerArr.max())
    }

}

private fun check(area: Array<MutableList<Int>>): Int {
    var safeArea = area
    var visited = Array(area.size) { Array(area.size) { 0 } }
    var count = 0

    for (i in area.indices) {
        for (j in area.indices) {
            if (safeArea[i][j] > 0 && visited[i][j] == 0) {
                bfs(safeArea, visited, i, j)
                count++
            }
        }
    }

    return count
}

private fun bfs(area: Array<MutableList<Int>>, visited: Array<Array<Int>>, x: Int, y: Int) {
    var q: Queue<Dot> = LinkedList<Dot>()

    q.offer(Dot(x, y))
    visited[x][y] = 1

    while (q.isNotEmpty()) {
        val temp = q.poll()

        for (i in 0 until 4) {
            val nx = temp.x + dx[i]
            val ny = temp.y + dy[i]

            if (nx in area.indices && ny in area.indices && visited[nx][ny] == 0 && area[nx][ny] > 0) {
                q.offer(Dot(nx, ny))
                visited[nx][ny] = 1
            }
        }
    }
}