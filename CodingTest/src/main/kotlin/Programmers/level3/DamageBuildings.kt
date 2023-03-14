import java.lang.StringBuilder
import java.util.*


class DamageBuildings {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        var damageBoard = Array(board.size + 2){ IntArray(board[0].size + 2){ 0 } }
        var sb = StringBuilder()

        for(element in skill){
            var x1 = element[1] + 1
            var y1 = element[2] + 1
            var x2 = element[3] + 1
            var y2 = element[4] + 1
            var degree = element[5]

            when(element[0]){
                1 -> {
                    damageBoard[x1][y1] += -degree
                    damageBoard[x1][y2 + 1] += degree
                    damageBoard[x2 + 1][y1] += degree
                    damageBoard[x2 + 1][y2 + 1] += -degree
                }

                else -> {
                    damageBoard[x1][y1] += degree
                    damageBoard[x1][y2 + 1] += -degree
                    damageBoard[x2 + 1][y1] += -degree
                    damageBoard[x2 + 1][y2 + 1] += degree
                }
            }
        }


        for(i in 1..board.size){
            var sum = 0
            for(j in 1..board[0].size){
                sum += damageBoard[i][j]
                damageBoard[i][j] = sum
            }
        }

//        println("x")
//        for(i in 1..board.size){
//            for(j in 1..board[0].size){
//                print("${damageBoard[i][j]} ")
//            }
//            println()
//        }

        for(i in 1..board[0].size){
            var sum = 0
            for(j in 1..board.size){
                sum += damageBoard[j][i]
                damageBoard[j][i] = sum
            }
        }

//        println("y")
//        for(i in 1..board.size){
//            for(j in 1..board[0].size){
//                print("${damageBoard[i][j]} ")
//            }
//            println()
//        }



        for(i in 1..board.size){
            for(j in 1..board[0].size){
                damageBoard[i][j] = damageBoard[i][j] + board[i - 1][j - 1]

                if(damageBoard[i][j] > 0)
                    answer++
            }
        }

        return answer
    }
}

fun main(args: Array<String>){
    val db = DamageBuildings()

}