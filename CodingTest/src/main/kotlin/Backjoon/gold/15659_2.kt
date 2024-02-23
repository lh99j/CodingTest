import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private lateinit var nums: MutableList<Int>
private lateinit var op: MutableList<Int>
private val opS = arrayOf("+", "-", "*", "/")
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
        val result = cal(mackPostfix(s))


        max = maxOf(result, max)
        min = minOf(result, min)

        return
    }


    for (i in 0..3) {
        if (op[i] > 0) {
            op[i]--
            back(depth + 1, str + "N" + opS[i])
            op[i]++
        }
    }
}

private fun mackPostfix(str: String): String {
    var sb = StringBuilder()
    var s = Stack<Char>()

    str.forEach {
        when (it) {
            'N' -> {
                sb.append(it)
            }

            '*', '/' -> {
                while (s.isNotEmpty() && !(s.peek() == '+' || s.peek() == '-')) {
                    sb.append(s.pop())
                }
                s.push(it)
            }

            else -> {
                while (s.isNotEmpty()) {
                    sb.append(s.pop())
                }
                s.push(it)
            }
        }
    }

    while (s.isNotEmpty()) {
        sb.append(s.pop())
    }

    return sb.toString()
}

private fun cal(str: String): Int {
    var depth = 0
    val s = Stack<Int>()

    str.forEach {
        if (it == 'N') {
            s.push(nums[depth])
            depth++
        } else {
            val second = s.pop()
            val first = s.pop()
            when (it) {
                '+' -> s.push(first + second)
                '-' -> s.push(first - second)
                '*' ->s.push(first * second)
                '/' -> s.push(first / second)
            }
        }
    }

    return s.pop()
}