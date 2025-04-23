import java.util.*

private val ans = mutableListOf<Int>()
private lateinit var upVisited: BooleanArray
private lateinit var downVisited: BooleanArray
private val list = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    upVisited = BooleanArray(n + 1) { false }
    downVisited = BooleanArray(n + 1) { false }
    val nums = Array(2) { IntArray(n + 1) { it } }
    var same = mutableListOf<Int>()

    repeat(n) { idx ->
        val num = br.readLine().toInt()
        nums[1][idx + 1] = num
    }

    for(i in 1..n){
        if(nums[0][i] == nums[1][i]){
            same.add(i)
            continue
        }

        if(!ans.contains(i)){
            list.clear()
            dfs(nums, i, i, 0)
        }
    }

    ans.addAll(same)
    println(ans.size)
    println(ans.sorted().joinToString("\n"))
}

private fun dfs(nums: Array<IntArray>, start: Int, cur: Int, total: Int){
    if(cur == start && total != 0){
        ans.addAll(list)
        return
    }

    if(list.contains(cur)){
        return
    }

    val next = nums[1][cur]

    upVisited[cur] = true
    downVisited[next] = true

    list.add(cur)
    dfs(nums, start, next, total + 1)
}