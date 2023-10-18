import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.system.exitProcess

private lateinit var board: Array<Array<Int>>
private lateinit var zeroPosition: MutableList<Pair<Int, Int>>
private var row = Array(10){ BooleanArray(10) { false } }
private var col = Array(10){ BooleanArray(10) { false } }
private var block = Array(10){ BooleanArray(10) { false } }

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
            else{
                row[i][board[i][j]] = true
                col[j][board[i][j]] = true
                block[3 * (i / 3) + j / 3][board[i][j]] = true
            }
        }
    }

    back(0)

    br.close()
}

private fun back(depth: Int) {
    if (depth == zeroPosition.size) {
        var sb = StringBuilder()
        for (i in board.indices) {
            for (j in board.indices) {
                sb.append(board[i][j]).append(" ")
            }
            sb.append("\n")
        }

        println(sb)
        exitProcess(0)
    }

    val (x, y) = zeroPosition[depth]
    val b = 3 * (x / 3) + y / 3

    for (i in 1 until 10) {
        if(!row[x][i] && !col[y][i] && !block[b][i]){
            row[x][i] = true
            col[y][i] = true
            block[b][i] = true

            board[x][y] = i
            back(depth + 1)
            board[x][y] = 0

            row[x][i] = false
            col[y][i] = false
            block[b][i] = false
        }
    }
}