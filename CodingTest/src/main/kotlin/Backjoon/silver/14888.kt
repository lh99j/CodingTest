import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var nums: List<Int>
private lateinit var op: MutableList<Int>
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    nums = br.readLine().split(" ").map { it.toInt() }
    op = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    dfs(nums[0], 1)
    println(max)
    println(min)
}

private fun dfs(value: Int, cnt: Int) {
    if (cnt == nums.size) {
        if (value > max) max = value
        if (value < min) min = value
        return
    }

    for (i in op.indices) {
        if (op[i] > 0) {
            op[i]--

            when (i) {
                0 -> dfs(value + nums[cnt], cnt + 1)
                1 -> dfs(value - nums[cnt], cnt + 1)
                2 -> dfs(value * nums[cnt], cnt + 1)
                3 -> dfs(value / nums[cnt], cnt + 1)
            }

            op[i]++
        }
    }
}