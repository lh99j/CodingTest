import java.util.*
import java.io.*

private lateinit var map: Array<IntArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

private var N: Int = 1
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = 1 shl st.nextToken().toInt()
    val Q = st.nextToken().toInt()

    map = Array(N) { IntArray(N) { 0 } }

    repeat(N) { idx ->
        st = StringTokenizer(br.readLine())

        for (i in 0 until N) {
            val value = st.nextToken().toInt()
            map[idx][i] = value
        }
    }

    val skills = br.readLine().split(" ").map { it.toInt() }

    skills.forEach {

        if (it > 0) {
            val level = 1 shl it
            tornado(level)
        }

        fireBall()
    }

    println(map.sumOf{ it.sum() })
    println(getIce())
}

private fun tornado(l: Int) {
    val new = Array(N) { IntArray(N) { 0 } }

    for (i in 0 until N step (l)) {
        for (j in 0 until N step (l)) {
            change(new, i, j, l)
        }
    }

    map = new
}

private fun fireBall() {
    val new = Array(N) { IntArray(N) { 0 } }

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] == 0) {
                continue
            }

            var cnt = 0
            for (d in 0..3) {
                val nx = i + dx[d]
                val ny = j + dy[d]

                if(validPosition(nx, ny) && map[nx][ny] != 0){
                    cnt++
                }
            }

            if(cnt < 3){
                new[i][j] = map[i][j] - 1
            }else{
                new[i][j] = map[i][j]
            }
        }
    }

    map = new
}

private fun getIce(): Int{
    var visited = Array(N) { BooleanArray(N) { false } }
    var ans = 0

    for(i in 0 until N){
        for(j in 0 until N){
            if(map[i][j] == 0 || visited[i][j]){
                continue
            }

            ans = maxOf(ans, bfs(visited, i, j))
        }
    }

    return ans
}


private fun bfs(visited: Array<BooleanArray>, x: Int, y: Int): Int{
    val q: Queue<Pair<Int, Int>> = LinkedList()
    var cnt = 1

    q.offer(x to y)
    visited[x][y] = true

    while(q.isNotEmpty()){
        val (cx, cy) = q.poll()

        for(i in 0..3){
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if(validPosition(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0){
                q.offer(nx to ny)
                visited[nx][ny] =true
                cnt++
            }
        }
    }

    return cnt
}

private fun change(new: Array<IntArray>, x: Int, y: Int, N: Int) {
    for (i in 0 until N) {
        for (j in 0 until N) {
            new[j + x][y + N - 1 - i] = map[x + i][y + j]
        }
    }
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until N