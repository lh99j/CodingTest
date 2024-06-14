import java.io.BufferedReader
import java.io.InputStreamReader

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private var N = 0
private var directions = Array(4) { Array(3) { IntArray(9) { 0 } } }
private lateinit var map: Array<MutableList<Int>>
private var ans = 0

private data class Tornado20057(var x: Int, var y: Int, var d: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    map = Array(N) { mutableListOf() }

    var tornado = Tornado20057(N / 2, N / 2, 0)

    repeat(N) { idx ->
        val inputs = br.readLine().split(" ").map { it.toInt() }
        map[idx].addAll(inputs)
    }

    settings()

    loop@ for (i in 1..N) {
        for (j in 1..2) {
            var (x, y, d) = tornado

            for (k in 0 until i) {
                x += dx[d]
                y += dy[d]

                if (!validPosition(x, y)) {
                    break@loop
                }

                moveSand(x, y, d)
            }

            d = getNextDirection(d)
            tornado = Tornado20057(x, y, d)
        }
    }

    println(ans)
}

private fun getNextDirection(d: Int) = if (d + 1 > 3) 0 else d + 1
private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until N

private fun settings() {
    directions[0][0] = intArrayOf(-1, -1, -1, -2, 0, 1, 1, 1, 2)
    directions[0][1] = intArrayOf(0, -1, 1, 0, -2, 0, 1, -1, 0)
    directions[0][2] = intArrayOf(7, 10, 1, 2, 5, 7, 1, 10, 2)

    directions[1][0] = intArrayOf(0, 0, 0, 0, -1, -1, 1, 1, 2)
    directions[1][1] = intArrayOf(-1, -2, 1, 2, -1, 1, -1, 1, 0)
    directions[1][2] = intArrayOf(7, 2, 7, 2, 1, 1, 10, 10, 5)

    directions[2][0] = intArrayOf(-1, -2, 1, 2, -1, 1, -1, 1, 0)
    directions[2][1] = intArrayOf(0, 0, 0, 0, -1, -1, 1, 1, 2)
    directions[2][2] = intArrayOf(7, 2, 7, 2, 1, 1, 10, 10, 5)

    directions[3][0] = intArrayOf(0, 0, 0, 0, -1, -1, 1, 1, -2)
    directions[3][1] = intArrayOf(-1, -2, 1, 2, -1, 1, -1, 1, 0)
    directions[3][2] = intArrayOf(7, 2, 7, 2, 10, 10, 1, 1, 5)
}

private fun moveSand(x: Int, y: Int, d: Int) {
    var value = map[x][y]
    var total = 0

    for (l in 0..8) {
        var temp: Double = directions[d][2][l] * 0.01
        var sand = (temp * value).toInt()
        total += sand

        val nx = x + directions[d][0][l]
        val ny = y + directions[d][1][l]

        if (validPosition(nx, ny)) {
            map[nx][ny] += sand
        } else {
            ans += sand
        }
    }

    map[x][y] -= total

    if (validPosition(x + dx[d], y + dy[d])) {
        map[x + dx[d]][y + dy[d]] += map[x][y]
    } else {
        ans += map[x][y]
    }

    map[x][y] = 0
}