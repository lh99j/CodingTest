import java.io.BufferedReader
import java.io.InputStreamReader

private var bans = mutableListOf<Int>()
private var d = 0
private var ans = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    d = br.readLine().toInt()
    val t = br.readLine().toInt()

    if (t != 0) {
        bans = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    }

    ans = Math.abs(d - 100)

    if (d == 100) {
        println(0)
    } else if (t == 0) {
        println(minOf(ans, d.toString().length))
    } else if (t == 10) {
        println(ans)
    } else {
        dfs(0, 0, d.toString().length + 1)
        println(ans)
    }
}

private fun dfs(cnt: Int, num: Int, depth: Int) {
    if (cnt == depth) {
        return
    }

    for (i in 0..9) {
        if (i !in bans) {
            val nNum = num * 10 + i
            ans = minOf(cnt + 1 + Math.abs(nNum - d), ans)
            dfs(cnt + 1, nNum, depth)
        }
    }
}