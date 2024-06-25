import java.io.*
import java.util.*

private data class Sharks17143(var x: Int, var y: Int, val s: Int, var d: Int, val z: Int)

private var ans = 0
private var N = 0
private var M = 0
private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private val sharks = mutableListOf<Sharks17143>()
private lateinit var sharkState: BooleanArray
private lateinit var board: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    board = Array(N) { IntArray(M) { -1 } }
    sharkState = BooleanArray(K) { true }

    repeat(K) { idx ->
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt() - 1
        val y = st.nextToken().toInt() - 1
        var s = st.nextToken().toInt()
        val d = st.nextToken().toInt() - 1
        val z = st.nextToken().toInt()

        s = if (d in 0..1) {
            s % ((N - 1) * 2)
        } else {
            s % ((M - 1) * 2)
        }

        sharks.add(Sharks17143(x, y, s, d, z))
        board[x][y] = idx
    }

    for (i in 0 until M) {
        fishing(i)
        moving()
    }

    println(ans)
}

private fun fishing(idx: Int) {
    for (i in 0 until N) {
        if (board[i][idx] != -1) {
            val sharkIdx = board[i][idx]
            sharkState[sharkIdx] = false
            ans += sharks[sharkIdx].z

            board[i][idx] = -1

            break
        }
    }
}

private fun moving() {
    val new = Array(N) { IntArray(M) { -1 } }
    for (i in sharks.indices) {
        if (!sharkState[i]) {
            continue
        }

        val shark = sharks[i]
        var x = shark.x
        var y = shark.y
        var d = shark.d

        repeat(shark.s) {
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (validPosition(nx, ny)) {
                x = nx
                y = ny
            } else {
                d = getOppositeDirection(d)
                x += dx[d]
                y += dy[d]
            }
        }

        if (new[x][y] == -1) {
            new[x][y] = i
            sharks[i].x = x
            sharks[i].y = y
            sharks[i].d = d
        } else {
            val getSharkIdx = new[x][y]
            val newShark = sharks[getSharkIdx]

            if (newShark.z > shark.z) {
                sharkState[i] = false
            } else {
                new[x][y] = i
                sharks[i].x = x
                sharks[i].y = y
                sharks[i].d = d
                sharkState[getSharkIdx] = false
            }
        }
    }

    board = new
}

private fun getOppositeDirection(d: Int): Int {
    return when (d) {
        0 -> 1
        1 -> 0
        2 -> 3
        3 -> 2
        else -> -1
    }
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until M