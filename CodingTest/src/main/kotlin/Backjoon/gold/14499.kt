import java.io.*
import java.lang.StringBuilder

private var dice = intArrayOf(0, 0, 0, 0, 0, 0)
private val dx = intArrayOf(0, 0, -1, 1)
private val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    var map = Array<MutableList<Int>>(inputs[0]) { mutableListOf() }
    var x = inputs[2]
    var y = inputs[3]

    repeat(inputs[0]) { idx ->
        val nums = br.readLine().split(" ").map { it.toInt() }
        map[idx].addAll(nums)
    }

    val move = br.readLine().split(" ").map { it.toInt() }

    move.forEach {
        val nx = x + dx[it - 1]
        val ny = y + dy[it - 1]

        if (nx in 0 until inputs[0] && ny in 0 until inputs[1]) {
            when (it) {
                1 -> right()
                2 -> left()
                3 -> up()
                4 -> down()
            }

            sb.append("${dice[5]}").append("\n")

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[0]
            } else {
                dice[0] = map[nx][ny]
                map[nx][ny] = 0
            }

            x = nx
            y = ny
        }
    }

    println(sb)
}

// 북
private fun up() {
    val t = dice.clone()

    dice[0] = t[1]
    dice[1] = t[5]
    dice[4] = t[0]
    dice[5] = t[4]
}

// 남
private fun down() {
    val t = dice.clone()

    dice[0] = t[4]
    dice[1] = t[0]
    dice[4] = t[5]
    dice[5] = t[1]
}

// 동
private fun right() {
    val t = dice.clone()

    dice[0] = t[2]
    dice[2] = t[5]
    dice[3] = t[0]
    dice[5] = t[3]
}

// 서
private fun left() {
    val t = dice.clone()

    dice[0] = t[3]
    dice[2] = t[0]
    dice[3] = t[5]
    dice[5] = t[2]
}