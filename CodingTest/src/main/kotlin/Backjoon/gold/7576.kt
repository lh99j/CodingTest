import java.io.*
import java.util.*
import kotlin.math.min

private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(1, 0, -1, 0)
private lateinit var valueArr: Array<Array<Int>>
private val MAX = 1_000_000

//private data class Dot(val x: Int, val y: Int)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    var tomatoMap = Array<MutableList<Int>>(n) { mutableListOf() }
    valueArr = Array(n) { Array(m) { MAX } }

    for (i in 0 until n) {
        val arr = br.readLine().split(" ").map { it.toInt() }
        tomatoMap[i].addAll(arr)
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (tomatoMap[i][j] == -1)
                valueArr[i][j] = -1
        }
    }

    var dotArray = mutableListOf<Dot>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (tomatoMap[i][j] == 1)
                dotArray.add(Dot(i, j))
        }
    }

    bfs(tomatoMap, dotArray)

    if (!tomatoMap.toList().flatten().contains(0)) {
        println("0")
    } else if (valueArr.flatten().contains(MAX)) {
        println("-1")
    } else {
        println(valueArr.flatten().max())
    }
}

private fun bfs(map: Array<MutableList<Int>>, dotArr: MutableList<Dot>) {
    var q: Queue<Dot> = LinkedList<Dot>()
    var visited = Array(map.size) { Array(map[0].size) { 0 } }

    dotArr.forEach {
        q.offer(Dot(it.x, it.y))
        valueArr[it.x][it.y] = 0
        visited[it.x][it.y] = 1
    }

    while (q.isNotEmpty()) {
        var temp = q.poll()

        for (i in 0 until 4) {
            var nx = temp.x + dx[i]
            var ny = temp.y + dy[i]

            if (nx in 0 until map.size && ny in 0 until map[0].size && map[nx][ny] == 0 && visited[nx][ny] != 1) {
                q.offer(Dot(nx, ny))
                visited[nx][ny] = 1
                valueArr[nx][ny] = min(valueArr[temp.x][temp.y] + 1, valueArr[nx][ny])
            }
        }

    }

    dotArr.forEach {
        valueArr[it.x][it.y] = -1
    }

}