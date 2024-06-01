import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var othello: Array<Array<String>>
private val dx = intArrayOf(-1, 1, 0, 0, 1, -1, 1, -1)
private val dy = intArrayOf(0, 0, 1, -1, 1, -1, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var cnt = br.readLine().toInt()
    othello = initBoard()
    // true : B , false : W
    var turnFlag = true

    repeat(cnt) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() - 1 }

        if (valid(x, y) && othello[x][y] == ".") {
            changeStones(x, y, turnFlag)
            turnFlag = !turnFlag
        }
    }

    othello.forEach {
        println(it.joinToString(""))
    }

    val blackCnt = othello.flatten().count { it == "B" }
    val whiteCnt = othello.flatten().count { it == "W" }
    println(if (blackCnt > whiteCnt) "Black" else "White")
}

private fun initBoard(): Array<Array<String>> {
    val othello = Array(6) { Array(6) { "." } }

    othello[2][2] = "W"
    othello[3][3] = "W"
    othello[2][3] = "B"
    othello[3][2] = "B"

    return othello
}

private fun changeStones(x: Int, y: Int, turnFlag: Boolean) {
    val currentStone = if (turnFlag) "B" else "W"
    othello[x][y] = currentStone

    for (i in 0..7) {
        if (changable(x, y, i, currentStone)) {
            var nx = x + dx[i]
            var ny = y + dy[i]

            while (valid(nx, ny) && othello[nx][ny] != currentStone) {
                othello[nx][ny] = currentStone
                nx += dx[i]
                ny += dy[i]
            }
        }
    }
}

private fun changable(x: Int, y: Int, d: Int, currentStone: String): Boolean {
    var count = 0
    var nx = x + dx[d]
    var ny = y + dy[d]

    while (valid(nx, ny) && othello[nx][ny] != "." && othello[nx][ny] != currentStone) {
        nx += dx[d]
        ny += dy[d]
        count++
    }

    return count > 0 && valid(nx, ny) && othello[nx][ny] == currentStone
}

private fun valid(x: Int, y: Int) = x in 0..5 && y in 0..5
