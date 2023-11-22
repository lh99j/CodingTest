import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()

    back(0, num, "")
}

private fun back(depth: Int, cnt: Int, str: String) {
    if (depth == cnt) {
        println(str)
        exitProcess(0)
    }

    for (i in 1..3) {
        val newStr = str + i.toString()
        if (isValid(newStr)) {
            back(depth + 1, cnt, newStr)
        }
    }
}

private fun isValid(str: String): Boolean {
    val len = str.length
    for(i in 1..len/2){
        val right = str.substring(len - i, len)
        val left = str.substring(len - i - i, len - i)
        if(left == right)
            return false
    }
    return true
}