import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.system.exitProcess

private var cnt = -1
private var visited = Array(10) { false }
private var size = 0
private lateinit var arr: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    size = readLine().toInt()

    for (i in 1..10) {
        arr = Array(i) { 0 }
        back(0, i)
    }

    println(-1)

}

private fun back(depth: Int, c: Int) {
    if (depth == c) {

        if (check(arr)) {
            cnt++
        }

        if (cnt == size) {
            val sb = StringBuilder()

            arr.forEach {
                sb.append(it)
            }
            println(sb)
            exitProcess(0)
        }

        return
    }

    for (i in 0 until 10) {
        if (visited[i])
            continue

        visited[i] = true
        arr[depth] = i
        back(depth + 1, c)
        visited[i] = false

    }
}

private fun check(nums: Array<Int>): Boolean {
    var max = nums[0]

    if (nums.size > 1) {
        for (i in 1 until nums.size) {
            if (max < nums[i]) {
                return false
            } else {
                max = nums[i]
            }
        }
    }

    return true
}

