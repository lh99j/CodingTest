import java.io.BufferedReader
import java.io.InputStreamReader

private val left = mutableListOf<Int>()
private val right = mutableListOf<Int>()
private lateinit var nums: List<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, C) = br.readLine().split(" ").map { it.toInt() }
    nums = br.readLine().split(" ").map { it.toInt() }

    getSum(left, 0, N / 2, 0, C)
    getSum(right, N / 2, N, 0, C)

    right.sort()

    var cnt = 0
    left.forEach {
        val idx = getIdx(right, C - it)
        cnt += idx + 1
    }

    println(cnt)
}

private fun getSum(list: MutableList<Int>, start: Int, end: Int, sum: Int, C: Int){
    if(sum > C){
        return
    }

    if(start == end){
        list.add(sum)
        return
    }

    getSum(list, start + 1, end, sum, C)
    getSum(list, start + 1, end, sum + nums[start], C)
}

private fun getIdx(list: MutableList<Int>, d: Int): Int {
    var left = 0
    var right = list.size - 1

    while (left <= right) {
        val mid = (left + right) / 2

        if (list[mid] <= d) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return (left + right) / 2
}