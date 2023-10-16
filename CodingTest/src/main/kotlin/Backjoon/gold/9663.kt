import java.io.BufferedReader
import java.io.InputStreamReader

private var count = 0
private var ans = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    count = n
    val board = Array(n) { Array(n) { 0 } }

    nQueen(board, 0, 0)

    println(ans)
}

private fun nQueen(board: Array<Array<Int>>, x: Int, cnt: Int) {
    if (cnt == count) {
        ans++
        return
    }

    for (y in 0 until count) {
        if (checkQueen(board, x, y)) {
            board[x][y] = 1
            nQueen(board, x + 1, cnt + 1)
            board[x][y] = 0
        }
    }
}

private fun checkQueen(board: Array<Array<Int>>, x: Int, y: Int): Boolean {
    //행만 확인
    for (i in 0 until x) {
        if (board[i][y] == 1) {
            return false
        }
    }

    //↖ 방향으로만 확인
    var i = x - 1
    var j = y - 1
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 1) {
            return false
        }
        i--
        j--
    }

    //↗방향으로만 확인
    i = x - 1
    j = y + 1
    while (i >= 0 && j < count) {
        if (board[i][j] == 1) {
            return false
        }
        i--
        j++
    }

    return true
}