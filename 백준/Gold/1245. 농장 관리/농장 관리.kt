import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
private lateinit var farm: MutableList<MutableList<Int>>
private lateinit var visited: List<BooleanArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    farm = MutableList(N) { mutableListOf() }
    visited = List(N) { BooleanArray(M) { false } }

    repeat(N) { idx ->
        val input = br.readLine().split(" ").map { it.toInt() }
        farm[idx].addAll(input)
    }

    var ans = 0
    val minH = farm.flatten().min()
    
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (!visited[i][j] && farm[i][j] > minH && isPeek(i, j)) {
                ans++
            }
        }
    }

    println(ans)

}

private fun isPeek(x: Int, y: Int): Boolean {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val cv = farm[x][y]
    var flag = true

    visited[x][y] = true
    q.offer(x to y)

    while(q.isNotEmpty()){
        val (cx, cy) = q.poll()

        for(i in 0..7){
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if(isValidPoint(nx, ny)){
                val nv = farm[nx][ny]

                if(cv < nv){
                    flag = false
                }

                if(!visited[nx][ny] && nv == cv){
                    visited[nx][ny] = true
                    q.offer(nx to ny)
                }
            }
        }
    }

    return flag
}

private fun isValidPoint(x: Int, y: Int) = x in 0 until farm.size && y in 0 until farm[0].size