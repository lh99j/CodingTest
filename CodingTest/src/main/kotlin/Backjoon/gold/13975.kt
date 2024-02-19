import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(cnt) {
        val size = br.readLine()
        val nums = br.readLine().split(" ").map { it.toLong() }
        sb.append(getTotalCost(nums)).append("\n")
    }

    println(sb)
}

private fun getTotalCost(nums: List<Long>): Long {
    val pq = PriorityQueue<Long>()
    var ans: Long = 0

    if(nums.size == 1){
        return nums[0]
    }

    nums.forEach { num ->
        pq.offer(num)
    }

    while (pq.size > 1) {
        val first = pq.poll()
        val second = pq.poll()
        val sum = first + second

        ans += sum
        pq.offer(sum)
    }

    return ans
}