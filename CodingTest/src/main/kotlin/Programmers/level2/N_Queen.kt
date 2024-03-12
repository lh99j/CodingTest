import java.util.*

class N_Queen {
    private lateinit var board: Array<Array<Int>>
    private lateinit var check: Array<Boolean>
    private var ans = 0

    fun solution(n: Int): Int {
        board = Array(n){Array(n) { 0 }}
        check = Array(n) { true }


        back(board.size - 1)

        return ans
    }

    private fun back(depth: Int){
        if(depth == -1){
            ans++
            return
        }


        for(i in 0 until board.size){
            if(check[i] && validPosition(depth, i)){
                check[i] = false
                board[depth][i] = 1

                back(depth - 1)

                check[i] = true
                board[depth][i] = 0
            }
        }
    }

    private fun validPosition(x: Int, y: Int): Boolean{
        //오른쪽 아래 대각
        var tx = x
        var ty = y
        for(i in x until board.size){
            tx++
            ty++

            if(tx in 0 until board.size && ty in 0 until board.size && board[tx][ty] == 1){
                return false
            }
        }



        //왼쪽 아래 대각
        tx = x
        ty = y
        for(i in x until board.size){
            tx++
            ty--

            if(tx in 0 until board.size && ty in 0 until board.size &&board[tx][ty] == 1){
                return false
            }
        }

        return true
    }
}