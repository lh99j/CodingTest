import java.io.BufferedReader
import java.io.InputStreamReader

private var moArr = charArrayOf('A', 'E', 'I', 'O', 'U')

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine()

    val an = checkValid(num, 0, 0, 0, 0)
    println(an)
}

private fun checkValid(inp: String, mo: Int, ja: Int, l: Int, index: Int): Long {
    var num: Long = 0

    if (mo >= 3 || ja >= 3)
        return 0

    if (index >= inp.length) {
        if (l == 0)
            return 0
        else
            return 1
    }

    if (inp[index] != '_') {
        if (moArr.contains(inp[index])) {
            num = checkValid(inp, mo + 1, 0, l, index + 1)
        } else {
            if (inp[index] == 'L')
                num = checkValid(inp, 0, ja + 1, l + 1, index + 1)
            else
                num = checkValid(inp, 0, ja + 1, l, index + 1)
        }
    }else{
        num += 5 * checkValid(inp, mo + 1, 0, l, index + 1)
        num += 20 * checkValid(inp, 0, ja + 1, l, index + 1)
        num += checkValid(inp, 0, ja + 1, l + 1, index + 1)
    }

    return num
}