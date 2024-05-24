import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var N = 0
private var M = 0
private lateinit var map: Array<Array<Int>>
private lateinit var check: Array<Array<Int>>
private data class Dot14502(val x: Int, val y: Int)
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var ans = 0

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    map = Array(N){ Array(M) { 0 } }

    repeat(N){ i ->
        val st = StringTokenizer(br.readLine())

        for(j in 0 until M){
            map[i][j] = st.nextToken().toInt()
        }
    }

    back(0, 0)

    println(ans)

}

private fun back(depth: Int, start: Int){
    if(depth == 3){
        check = Array(N){ idx -> map[idx].clone() }

        for(i in 0 until N){
            for(j in 0 until M){
                if(check[i][j] == 2){
                    bfs(Dot14502(i, j))
                }
            }
        }

        ans = maxOf(ans, check.sumOf { row -> row.count { it == 0 } })

        return
    }

    for(i in start until N * M){
        val x = i / M
        val y = i % M

        if(map[x][y] == 0){
            map[x][y] = 1
            back(depth + 1, i + 1)
            map[x][y] = 0
        }
    }
}

private fun bfs(d: Dot14502){
    val q: Queue<Dot14502> = LinkedList()

    q.offer(d)

    while (q.isNotEmpty()){
        val (x, y) = q.poll()

        for(i in 0..3){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until N && ny in 0 until M && check[nx][ny] == 0){
                check[nx][ny] = 2
                q.offer(Dot14502(nx, ny))
            }
        }
    }
}