import kotlin.system.exitProcess

fun main() {
    val br = System.`in`.bufferedReader()
    val k = br.readLine().toInt()
    val n = br.readLine().toInt()
    val d = br.readLine().map { it.code - 65}
    val ladder = Array(n) { CharArray(k + 1) { '*' } }
    val cur = Array(k) { IntArray(2) { -1 } }
    var q = -1
    var ans = ""

    repeat(n) { i ->
        br.readLine().mapIndexed { j, c ->
            ladder[i][j + 1] = c

            if(c == '?') q = i
        }
    }


    for(i in 0 until k) {
        var (x, y) = 0 to i

        for(j in 0 until q) {
            if(ladder[x][y] == '-' && ladder[x][y + 1] == '*') {
                y--
            }else if(ladder[x][y] == '*' && ladder[x][y + 1] == '-') {
                y++
            }

            x++
        }

        cur[y][0] = i
    }

    for(i in 0 until k) {
        var (x, y) = n - 1 to i

        for(j in n - 1 downTo q + 1) {
            if(ladder[x][y] == '-' && ladder[x][y + 1] == '*') {
                y--
            }else if(ladder[x][y] == '*' && ladder[x][y + 1] == '-') {
                y++
            }
            x--
        }

        cur[y][1] = d[i]
    }

    var skip = false

    for(i in 0 until cur.size - 1) {
        if(skip) {
            skip = false
            ans += "*"
            continue
        }
        if(cur[i][0] == cur[i][1]) {
            ans += "*"
        } else if (cur[i][0] == cur[i + 1][1] && cur[i + 1][0] == cur[i][1]) {
            ans += '-'
            skip = true
        }else {
            println("x".repeat(k - 1))
            exitProcess(0)
        }
    }

    println(ans)
}