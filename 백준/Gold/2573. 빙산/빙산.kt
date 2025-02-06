import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var ices: Array<IntArray>
private val q: Queue<Pair<Int, Int>> = LinkedList()
private lateinit var visited: Array<BooleanArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ices = Array(n) { IntArray(m) { 0 } }
    visited = Array(n) { BooleanArray(m) { false } }

    repeat(n) { i ->
        br.readLine().split(" ").map { it.toInt() }.forEachIndexed { j, v ->
            if (v != 0) {
                q.offer(i to j)
            }

            ices[i][j] = v
        }
    }


    var ans = 0
    while(true){
        var cnt = 0
        for(i in 0 until n){
            for(j in 0 until m){
                if(ices[i][j] > 0 && !visited[i][j]){
                    bfs(i, j)
                    cnt++
                }
            }
        }

        if(cnt > 1){
            break
        }

        ans++

        melt()

//        for(i in 0 until n){
//            for(j in 0 until m){
//                print("${ices[i][j]} ")
//            }
//            println()
//        }
//
//        println()

        if(q.isEmpty()){
             ans = 0
            break
        }

        visited = Array(n) { BooleanArray(m) { false } }
    }
    println(ans)
}

private fun melt() {
    val size = q.size
    val newIces: Array<IntArray> = ices.map { it.clone() }.toTypedArray()

    repeat(size) {
        val (x, y) = q.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (check(nx, ny) && ices[nx][ny] <= 0) {
                newIces[x][y] -= 1
            }
        }

        q.offer(x to y)
    }

    repeat(size){
        val (x, y) = q.poll()

        if(newIces[x][y] > 0){
            q.offer(x to y)
        }
    }

    ices = newIces
}

private fun bfs(x: Int, y: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()

    visited[x][y] = true
    q.offer(x to y)

    while(q.isNotEmpty()){
        val (cx, cy) = q.poll()

        for(i in 0..3){
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if(check(nx, ny) && ices[nx][ny] > 0 && !visited[nx][ny]){
                q.offer(nx to ny)
                visited[nx][ny] = true
            }
        }
    }
}

private fun check(x: Int, y: Int) = x in ices.indices && y in 0 until ices[0].size
