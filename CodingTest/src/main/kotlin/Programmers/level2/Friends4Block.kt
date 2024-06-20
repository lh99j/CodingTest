import java.util.*

private val dx = intArrayOf(0, 1, 1)
private val dy = intArrayOf(1, 0, 1)

class Friends4Block {
    private var M = 0
    private var N = 0
    private lateinit var map: Array<MutableList<String>>

    fun solution(m: Int, n: Int, board: Array<String>): Int {
        map = Array(m) { mutableListOf() }
        N = n
        M = m

        for (i in board.indices) {
            val values = board[i].chunked(1)
            map[i].addAll(values)
        }

        while (true) {
            if (!boom()) {
                break
            }

            pushMap()
        }

        return map.sumOf{ it.count { value -> value == " " } }
    }

    private fun boom(): Boolean {
        var new = Array(M) { MutableList(N) { "." } }
        var isBoom = false

        for (i in 0 until M) {
            for (j in 0 until N) {
                if (map[i][j] == " ") {
                    new[i][j] = " "
                    continue
                }

                var cnt = 1

                for (d in 0..2) {
                    val nx = i + dx[d]
                    val ny = j + dy[d]

                    if (validPosition(nx, ny) && map[nx][ny] == map[i][j]) {
                        cnt++
                    }
                }

                if (cnt == 4) {
                    new[i][j] = " "
                    new[i + dx[0]][j + dy[0]] = " "
                    new[i + dx[1]][j + dy[1]] = " "
                    new[i + dx[2]][j + dy[2]] = " "

                    isBoom = true
                } else {
                    new[i][j] = if(new[i][j] != " ") map[i][j] else new[i][j]
                }
            }
        }

        map = new

        return isBoom
    }

    private fun pushMap() {
        for(j in 0 until N){
            val s = Stack<String>()
            for(i in 0 until M){
                if(map[i][j] != " "){
                    s.push(map[i][j])
                }
            }

            for(i in M - 1 downTo 0){
                if(s.isNotEmpty()){
                    map[i][j] = s.pop()
                }else{
                    map[i][j] = " "
                }
            }
        }
    }

    private fun validPosition(x: Int, y: Int) = x in 0 until M && y in 0 until N
}

fun main(){
    val fb = Friends4Block()
    println(fb.solution(6, 6, arrayOf("TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ")))
}

