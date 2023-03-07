import java.io.*
import java.lang.StringBuilder

var visitedArr1 = mutableListOf<Int>()
var seq1 = 0

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

    visitedArr1 = MutableList<Int>(n) { 0 }

    dfs1(dfsMat, r - 1)

    visitedArr1.forEach {
        sb.append(it).append("\n")
    }

    println(sb)
}

fun dfs1(mat: Array<Array<Int>>, r: Int) {
    visitedArr1[r] = ++seq1

    for (i in visitedArr1.size - 1 downTo 0) {
        if (mat[r][i] == 1 && visitedArr1[i] == 0)
            dfs1(mat, i)
    }

}

//var visited = intArrayOf()
//var order = 0

//fun main() {
//    val inputs = readln().split(" ").map{ it.toInt() }
//    val pointCount = inputs[0]
//    val lineCount = inputs[1]
//    val startPoint = inputs[2] - 1
//    val lines = Array<MutableList<Int>>(pointCount) { mutableListOf() }
//    repeat(lineCount) {
//        readln().split(" ").map { it.toInt() - 1 }.let {
//            lines[it.first()].add(it.last())
//            lines[it.last()].add(it.first())
//        }
//    }
//    lines.forEach { it.sortDescending() }
//
//    visited = IntArray(pointCount) { order }
//
//    dfs(lines, startPoint)
//
//    visited.forEach { println(it) }
//}
//
//fun dfs(lines: Array<MutableList<Int>>, startPoint: Int) {
//    visited[startPoint] = ++order
//    lines[startPoint].forEach {
//        if(visited[it] == 0) dfs(lines, it)
//    }
//}
//fun dfs(lines: Array<MutableList<Int>>, startPoint: Int) {
//    visited[startPoint] = ++order
//    lines[startPoint].forEach {
//        if(visited[it] == 0) dfs(lines, it)
//    }