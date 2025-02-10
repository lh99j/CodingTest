import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var map: Array<Array<String>>
private val q: Queue<Pair<Int, Int>> = LinkedList()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    map = Array(n) { Array(n) { "X" } }

    repeat(n) { i ->
        br.readLine().split(" ").forEachIndexed { j, s ->
            if (s == "T")
                q.offer(i to j)

            map[i][j] = s
        }
    }

    back(0, n, 0)
    println("NO")
}

private fun back(depth: Int, n: Int, pre: Int) {
    if (depth == 3) {
        if (noS()) {
            println("YES")
            exitProcess(0)
        }

        return
    }

    for (i in pre until n * n) {
        val x = i / n
        val y = i % n

        if (map[x][y] == "X") {
            map[x][y] = "O"
            back(depth + 1, n, pre + 1)
            map[x][y] = "X"
        }
    }
}

private fun noS(): Boolean {
    val size = q.size

    for(i in 0 until size){
        val (x, y) = q.poll()
        q.offer(x to y)

        for(d in 0..3){
            if(!noSD(x, y, d)){
                return false
            }
        }
    }

    return true
}

private fun isValidPoint(x: Int, y: Int) = x in map.indices && y in map.indices

private fun noSD(x: Int, y: Int, d: Int): Boolean{
    var nx = x + dx[d]
    var ny = y + dy[d]

    while(isValidPoint(nx, ny)){
        if(map[nx][ny] == "S"){
            return false
        }

        if(map[nx][ny] == "O" || map[nx][ny] == "T"){
            return true
        }

        if(map[nx][ny] == "X"){
            nx += dx[d]
            ny += dy[d]
        }
    }

    return true
}
