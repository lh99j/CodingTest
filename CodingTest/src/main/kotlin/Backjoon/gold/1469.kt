import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

private var nums = mutableListOf<Int>()
private lateinit var input: Array<Int>
private lateinit var visited: Array<Boolean>
private var size = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    size = cnt * 2
    val arr = br.readLine().split(" ").map { it.toInt() }
    nums.addAll(arr)
    nums.sort()
    input = Array(size) { -1 }
    visited = Array(cnt) { false }

    back(0)
    println("-1")
}

private fun back(cnt: Int) {
    if (cnt == size) {
        println(input.joinToString(" "))
        exitProcess(0)
    }

    if(input[cnt] != -1){
        back(cnt + 1)
    }

    for (i in nums.indices) {
        if (!visited[i] && cnt + nums[i] + 1 < size && input[cnt] == -1 && input[cnt + nums[i] + 1] == -1) {
            input[cnt] = nums[i]
            input[cnt + nums[i] + 1] = nums[i]
            visited[i] = true
            back(cnt + 1)
            input[cnt] = -1

            input[cnt + nums[i] + 1] = -1
            visited[i] = false
        }
    }
}