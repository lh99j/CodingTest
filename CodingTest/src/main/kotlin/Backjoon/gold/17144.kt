import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.*

private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)
private var upPosition = mutableListOf<Pair<Int, Int>>()
private var downPosition = mutableListOf<Pair<Int, Int>>()
private lateinit var room: Array<IntArray>
private var cleaner = mutableListOf<Pair<Int, Int>>()
private var N = 0
private var M = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    var T = st.nextToken().toInt()
    room = Array(N) { IntArray(M) { 0 } }
    cleaner = mutableListOf()

    repeat(N) { idx ->
        st = StringTokenizer(br.readLine())

        for (i in 0 until M) {
            val next = st.nextToken().toInt()

            if (next == -1) {
                cleaner.add(idx to i)
            }

            room[idx][i] = next
        }
    }

    cleanerSettings(cleaner)

    while (T > 0) {
        spreadDust()
        workCleaner()
        T--
    }

    println(room.sumOf { it.sum() } + 2)
}

private fun spreadDust() {
    val nextRoom = Array(N) { IntArray(M) { 0 } }

    for(i in 0 until N){
        for(j in 0 until M){
            if(room[i][j] > 0){
                var cnt = 0
                var div = room[i][j] / 5
                for(d in 0..3){
                    val nx = i + dx[d]
                    val ny = j + dy[d]

                    if(validPosition(nx, ny) && room[nx][ny] != -1){
                        cnt++
                        nextRoom[nx][ny] += div
                    }
                }

                nextRoom[i][j] += room[i][j] - div * cnt
            }
        }
    }

    room = nextRoom
    room[cleaner[0].first][0] = -1
    room[cleaner[1].first][0] = -1
}

private fun workCleaner() {
    for (i in 1 until upPosition.size) {
        val pre = upPosition[i - 1]
        val cur = upPosition[i]

        room[pre.first][pre.second] = room[cur.first][cur.second]
        room[cur.first][cur.second] = 0
    }

    for (i in 1 until downPosition.size) {
        val pre = downPosition[i - 1]
        val cur = downPosition[i]

        room[pre.first][pre.second] = room[cur.first][cur.second]
        room[cur.first][cur.second] = 0
    }
}

private fun cleanerSettings(cleaner: MutableList<Pair<Int, Int>>) {
    var (x1, y1) = cleaner[0]
    var (x2, y2) = cleaner[1]


    //아래
    for (i in x2 + 1 until N) {
        downPosition.add(i to 0)
    }

    for (i in x1 - 1 downTo 0) {
        upPosition.add(i to 0)
    }

    for (i in 0 until M) {
        upPosition.add(0 to i)
        downPosition.add(N - 1 to i)
    }

    for (i in 0..x1) {
        upPosition.add(i to M - 1)
    }

    for (i in M - 1 downTo y1 + 1) {
        upPosition.add(x1 to i)
    }


    for (i in N - 1 downTo x2) {
        downPosition.add(i to M - 1)
    }

    for (i in M - 1 downTo y2 + 1) {
        downPosition.add(x2 to i)
    }

    upPosition = upPosition.toSet().toMutableList()
    downPosition = downPosition.toSet().toMutableList()
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until M