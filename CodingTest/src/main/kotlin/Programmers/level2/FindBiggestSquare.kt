class FindBiggestSquare {
    fun solution(b: Array<IntArray>): Int {
        var board = b
        for(i in 1 until board.size){
            for(j in 1 until board[0].size){
                if(b[i][j] == 1){
                    board[i][j] = minOf(minOf(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1
                }
            }
        }

        val maxValue = board.maxOf { it.max() }
        return maxValue * maxValue
    }
}

fun main() {
    val fbs = FindBiggestSquare()
    println(
        fbs.solution(
            arrayOf(
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0)
            )
        )
    )

    println(
        fbs.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 1),
                intArrayOf(1, 1, 1, 1)
            )
        )
    )
}