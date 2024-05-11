import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var nums: Array<MutableList<Int>>
private lateinit var visited: Array<Array<Boolean>>
private var max = 0
private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)
private var xS = 0
private var yS = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    xS = x
    yS = y
    nums = Array<MutableList<Int>>(x) { mutableListOf() }
    visited = Array(x) { Array(y) { false } }

    repeat(x) { idx ->
        val inputs = br.readLine().split(" ").map { it.toInt() }
        nums[idx].addAll(inputs)
    }


    for (i in 0 until x) {
        for (j in 0 until y) {
            visited[i][j] = true
            dfs(1, nums[i][j], i, j)
            visited[i][j] = false

            check(i, j)
        }
    }


    println(max)
}

private fun dfs(depth: Int, value: Int, x: Int, y: Int) {
    if(depth == 4){
        max = maxOf(value, max)
        return
    }

    for(i in 0 until 4){
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx in 0 until xS && ny in 0 until yS && !visited[nx][ny]){
            visited[nx][ny] = true
            dfs(depth + 1, value + nums[nx][ny], nx, ny)
            visited[nx][ny] = false
        }
    }
}

private fun check(x: Int, y: Int){
    if(y - 1 in 0 until yS && y + 1 in 0 until yS){
        val value = nums[x][y] + nums[x][y - 1] + nums[x][y + 1]
        //ㅜ
        if(x + 1 in 0 until xS){
            max = maxOf(max, value + nums[x + 1][y])
        }

        //ㅗ
        if(x - 1 in 0 until xS){
            max = maxOf(max, value + nums[x - 1][y])
        }

    }

    if(x - 1 in 0 until xS && x + 1 in 0 until xS){
        val value = nums[x][y] + nums[x - 1][y] + nums[x + 1][y]
        //ㅓ
        if(y - 1 in 0 until yS){
            max = maxOf(max, value + nums[x][y - 1])
        }

        //ㅏ
        if(y + 1 in 0 until yS){
            max = maxOf(max, value + nums[x][y + 1])
        }
    }
}