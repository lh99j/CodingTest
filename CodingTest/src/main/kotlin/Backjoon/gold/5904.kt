import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine().toInt()


    mooGame(input, 1, 3)

}

private fun mooGame(inp: Int, k: Int, len: Int){
    var nLn = 2 * len + (k + 3)

    if(inp <= 3){
        if(inp == 1){
            println("m")
            return
        }else{
            println("o")
            return
        }
    }

    if(nLn < inp){
        mooGame(inp, k + 1, nLn)
    }else{
        if(len < inp && inp <= len + k + 3){
            if(inp - len == 1){
                println("m")
            }else{
                println("o")
            }
        }else{
            mooGame(inp - (len + k + 3), 1, 3)
        }
    }
}

