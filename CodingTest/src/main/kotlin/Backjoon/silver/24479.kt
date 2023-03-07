import java.io.*
import java.lang.StringBuilder

var visitedArr = mutableListOf<Int>()
var seq = 0

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, m, r) = br.readLine().split(" ").map { it.toInt() }

    var dfsMat = Array(n) { Array(n) { 0 } }
    var sb = StringBuilder()

    for (i in 0 until m) {
        var (start, end) = br.readLine().split(" ").map { it.toInt() }
        dfsMat[start - 1][end - 1] = 1
        dfsMat[end - 1][start - 1] = 1
    }

    visitedArr = MutableList<Int>(n) { 0 }

    dfs(dfsMat, r - 1)

    visitedArr.forEach {
        sb.append(it).append("\n")
    }

    println(sb)
}

fun dfs(mat: Array<Array<Int>>, r: Int) {
    visitedArr[r] = ++seq

    for (i in 0 until visitedArr.size) {
        if(mat[r][i] == 1 && visitedArr[i] == 0)
            dfs(mat, i)
    }

}