import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }

    var lis = mutableListOf<Int>()
    lis.add(inputs[0])

    for (i in 1 until size) {
        if (lis.last() < inputs[i]) {
            lis.add(inputs[i])
        } else {
            val idx = getIndex(lis, inputs[i])
            lis[idx] = inputs[i]
        }
    }

    println(lis.size)
}

private fun getIndex(lis: MutableList<Int>, value: Int): Int {
    var left = 0
    var right = lis.lastIndex

    while (left <= right) {
        val mid = (left + right) / 2

        when {
            lis[mid] == value -> return mid
            lis[mid] < value -> left = mid + 1
            lis[mid] > value -> right = mid - 1
        }
    }

    return left
}