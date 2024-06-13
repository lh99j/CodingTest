import java.io.*
import java.util.StringTokenizer
import java.util.*

private const val LIMIT = 1_000
private var N = 0
private var M = 0
private var K = 0
private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    K = st.nextToken().toInt()

    val map = Array(N) { Array(N) { Pair(0, 0) } }
    val sharks = Array(M + 1) { Triple(-1, -1, -1) }
    val priorityDirection = Array(M + 1) { Array(16) { mutableListOf<Int>() } }

    repeat(N) { i ->
        st = StringTokenizer(br.readLine())

        for (j in 0 until N) {
            val value = st.nextToken().toInt()

            map[i][j] = value to 0

            if (value > 0) {
                sharks[value] = Triple(i, j, 0)
                map[i][j] = value to 0
            }
        }
    }

    st = StringTokenizer(br.readLine())
    for (i in 1..M) {
        val (x, y, d) = sharks[i]
        sharks[i] = Triple(x, y, st.nextToken().toInt() - 1)
    }

    repeat(M) { idx ->
        repeat(4) { d ->
            val inputs = br.readLine().split(" ").map { it.toInt() - 1 }
            priorityDirection[idx + 1][d].addAll(inputs)
        }
    }

    var time = 0
    while (time < LIMIT) {
        if (sharks.count { it.first >= 0 } == 1) {
            break
        }

        var moveShark: Queue<Triple<Int, Int, Int>> = LinkedList() //sharkNum, x, y

        //상어 이동
        for (i in 1..M) {
            if (sharks[i].first == -1)
                continue

            val (x, y, d) = sharks[i]
            var isMove = false

            for (j in 0..3) {
                val nd = priorityDirection[i][d][j]
                val nx = x + dx[nd]
                val ny = y + dy[nd]

                if (validPosition(nx, ny) && (map[nx][ny].first == 0 || time - map[nx][ny].second >= K)) {
                    moveShark.offer(Triple(i, nx, ny))
                    sharks[i] = Triple(nx, ny, nd)
                    isMove = true
                    break
                }
            }

            if (!isMove) {
                for (j in 0..3) {
                    val nd = priorityDirection[i][d][j]
                    val nx = x + dx[nd]
                    val ny = y + dy[nd]


                    if (validPosition(nx, ny) && map[nx][ny].first == i && time - map[nx][ny].second < K) {
                        moveShark.offer(Triple(i, nx, ny))
                        sharks[i] = Triple(nx, ny, nd)
                        break
                    }
                }
            }

        }

        while (moveShark.isNotEmpty()){
            val (idx, x, y) = moveShark.poll()

            if(map[x][y].first != 0 && map[x][y].first != idx && time - map[x][y].second < K){
                sharks[idx] = Triple(-1, -1, -1)
                continue
            }

            map[x][y] = idx to time + 1
        }


        time++
    }

    println(if(time == LIMIT) -1 else time)
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until N