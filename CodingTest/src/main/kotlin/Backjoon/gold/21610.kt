import java.io.*
import java.util.*

private var N = 0
private val dx = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
private val dy = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private lateinit var basket: Array<IntArray>
private val cloud: Queue<Pair<Int, Int>> = LinkedList()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    basket = Array(N) { IntArray(N) }

    repeat(N) { idx ->
        st = StringTokenizer(br.readLine())

        for (i in 0 until N) {
            basket[idx][i] = st.nextToken().toInt()
        }
    }

    initCloud()

    repeat(M) { idx ->
        st = StringTokenizer(br.readLine())
        val d = st.nextToken().toInt() - 1
        val s = st.nextToken().toInt()

        cycle(d, s)
    }


    println(basket.sumOf { it.sum() })
}

private fun cycle(d: Int, s: Int) {
    val isCloud = Array(N) { BooleanArray(N) { false } }

    repeat(cloud.size) {
        val p = cloud.poll()
        val (x, y) = getNextPosition(p, s, d)
        basket[x][y]++
        cloud.offer(x to y)
    }

    while (cloud.isNotEmpty()) {
        val (x, y) = cloud.poll()
        isCloud[x][y] = true

        val cnt = getWaterCnt(x to y)
        basket[x][y] += cnt
    }

    for(i in 0 until N){
        for(j in 0 until N){
            if(isCloud[i][j] || basket[i][j] < 2){
                continue
            }

            basket[i][j] -= 2
            cloud.offer(i to j)
        }
    }
}

private fun getNextPosition(pair: Pair<Int, Int>, s: Int, d: Int): Pair<Int, Int> {
    var (x, y) = pair

    repeat(s) {
        x = (x + dx[d] + N) % N
        y = (y + dy[d] + N) % N
    }

    return x to y
}

private fun getWaterCnt(pair: Pair<Int, Int>): Int {
    var cnt = 0
    var d = 1
    val (x, y) = pair

    repeat(4){
        val nx = x + dx[d]
        val ny = y + dy[d]

        if(validPosition(nx, ny) && basket[nx][ny] > 0){
            cnt++
        }

        d += 2
    }

    return cnt
}

private fun initCloud(){
    cloud.offer(N -1 to 0)
    cloud.offer(N - 1 to 1)
    cloud.offer(N - 2 to 0)
    cloud.offer(N - 2 to 1)
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until N