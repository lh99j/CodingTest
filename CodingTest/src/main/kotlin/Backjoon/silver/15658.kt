import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

private lateinit var opQuantity: MutableList<Int>
private lateinit var nums: List<Int>
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine()
    nums = br.readLine().split(" ").map { it.toInt() }
    opQuantity = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    back(1, nums.size, nums[0])
    println(max)
    println(min)

}

private fun back(c: Int, d: Int, value: Int) {
    if (c == d) {
        max = maxOf(value, max)
        min = minOf(value, min)
        return
    }

    for (i in 0..3) {
        if (opQuantity[i] > 0) {
            opQuantity[i]--
            val v = cal(value, nums[c], i)
            back(c + 1, d, v)
            opQuantity[i]++
        }
    }
}

private fun cal(value: Int, num: Int, type: Int): Int {
    var v = 0
//    println("$value $num $type")

    when (type) {
        0 -> {
            v = value + num
        }

        1 -> {
            v = value - num
        }

        2 -> {
            v = value * num
        }

        3 -> {
            v = if (value > 0) {
                value / num
            } else {
                (abs(value) / num) * -1
            }
        }
    }

    return v
}