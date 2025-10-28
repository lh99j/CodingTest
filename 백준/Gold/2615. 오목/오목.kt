import kotlin.system.exitProcess

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)

fun main() {
    val br = System.`in`.bufferedReader()
    val board = Array(19) { IntArray(19) }
    val stones = mutableListOf<Triple<Int, Int, Int>>()

    repeat(19) { i ->
        br.readLine().split(" ").map { it.toInt() }.forEachIndexed { j, value ->
            board[i][j] = value
            if(value != 0) {
                stones.add(Triple(i, j, value))
            }
        }
    }

    loop@for(s in stones) {
        val (x, y, v) = s

        for(i in 0..7) {
            if(check(board, x, y, i, v)) {
                println(v)
                val ex = x + (dx[i] * 4)
                val ey = y + (dy[i] * 4)

                if(y < ey) {
                    println("${x + 1} ${y + 1}")
                } else if(y > ey) {
                    println("${ex + 1} ${ey + 1}")
                } else {
                    if(x < ex) {
                        println("${x + 1} ${y + 1}")
                    }else {
                        println("${ex + 1} ${ey + 1}")
                    }
                }
                exitProcess(0)
            }
        }
    }

    println("0")
}

private fun check(map: Array<IntArray>, x: Int, y: Int, d: Int, v: Int): Boolean {
    var nx = x
    var ny = y
    for(i in 1..4) {
        nx += dx[d]
        ny += dy[d]

        if(nx in 0..18 && ny in 0..18 && map[nx][ny] == v){
            continue
        } else {
            return false
        }
    }

    nx += dx[d]
    ny += dy[d]

    return if(nx in 0..18 && ny in 0..18 && map[nx][ny] == v){
        false
    } else {
        val dd = getOpposite(d)
        val ddx = x + dx[dd]
        val ddy = y + dy[dd]
        return !(ddx in 0..18 && ddy in 0..18 && map[ddx][ddy] == v)
    }
}

private fun getOpposite(d: Int): Int {
    return when(d) {
        0 -> 4
        1 -> 5
        2 -> 6
        3 -> 7
        4 -> 0
        5 -> 1
        6 -> 2
        else -> 7
    }
}