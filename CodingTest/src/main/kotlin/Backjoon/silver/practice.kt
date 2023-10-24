import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.system.exitProcess

private lateinit var board: Array<Array<Int>>
private lateinit var zeroPosition: MutableList<Pair<Int, Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    board = Array(9) { Array(9) { 0 } }
    zeroPosition = mutableListOf()

    repeat(9) { i ->
        var st = StringTokenizer(br.readLine())
        for (j in board.indices) {
            board[i][j] = st.nextToken().toInt()
            if (board[i][j] == 0)
                zeroPosition.add(Pair(i, j))
        }
    }

    back(0)
}

private fun back(depth: Int) {
    if (depth == zeroPosition.size) {
        for (i in board.indices) {
            for (j in board.indices) {
                print("${board[i][j]} ")
            }
            println()
        }

        exitProcess(0)
    }

    val x = zeroPosition[depth].first
    val y = zeroPosition[depth].second

    for (i in 1 until 10) {
        if (check(x, y, i)) {
            board[x][y] = i
            back(depth + 1)
            board[x][y] = 0
        }
    }
}

private fun check(x: Int, y: Int, value: Int): Boolean {
    var checkValue = value

    for (i in board.indices) {
        if (i == y)
            continue

        if (board[x][i] == checkValue)
            return false
    }

    for (i in board.indices) {
        if (i == x)
            continue

        if (board[i][y] == checkValue)
            return false
    }

    var startX = (x / 3) * 3
    var startY = (y / 3) * 3

    for (i in 0..2) {
        for (j in 0..2) {
            if (i == x && j == y)
                continue

            if (board[startX + i][startY + j] == checkValue)
                return false
        }
    }

//    println("$x $y $checkValue")
    return true
}

private fun makeZero(depth: Int){
    for(i in depth until zeroPosition.size){
        val x = zeroPosition[i].first
        val y = zeroPosition[i].second

        board[x][y] = 0
    }
}