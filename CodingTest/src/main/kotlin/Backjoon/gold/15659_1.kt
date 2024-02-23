import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var nums: MutableList<Int>
private lateinit var op: MutableList<Int>
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    nums = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    //[+, -, *, /]
    op = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    back(0, "")

    println(max)
    println(min)
}

private fun back(depth: Int, str: String) {
    if (depth == nums.size - 1) {
        var s = str + "N"
        val result = getValue(s)

        max = maxOf(result, max)
        min = minOf(result, min)

        return
    }


    for (i in 0..3) {
        if (op[i] > 0) {
            op[i]--
            back(depth + 1, str + "N" + i)
            op[i]++
        }
    }
}

private fun getValue(str: String): Int {
    var s = Stack<Char>()
    var numS = Stack<Int>()
    var depth = 0

    str.forEach {
        when (it) {
            'N' -> {
                numS.push(nums[depth])
                depth++
            }

            '2', '3' -> {
                while (s.isNotEmpty() && !(s.peek() == '0' || s.peek() == '1')) {
                    val second = numS.pop()
                    val first = numS.pop()
                    numS.push(cal(first, second, s.pop()))

                }

                s.push(it)
            }

            else -> {
                while (s.isNotEmpty()) {
                    val second = numS.pop()
                    val first = numS.pop()
                    numS.push(cal(first, second, s.pop()))
                }
                s.push(it)
            }
        }
    }

    while (s.isNotEmpty()) {
        val second = numS.pop()
        val first = numS.pop()
        numS.push(cal(first, second, s.pop()))
    }

    return numS.pop()
}

private fun cal(first: Int, second: Int, op: Char): Int {

    return when (op) {
        '0' -> first + second
        '1' -> first - second
        '2' -> first * second
        else -> first / second
    }
}
