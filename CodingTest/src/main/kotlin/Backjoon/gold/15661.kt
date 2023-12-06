import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs

private lateinit var check: Array<Int>
private lateinit var scores: Array<MutableList<Int>>
private val ans = mutableListOf<Int>()
private var sum = 0
private var sumArr = mutableListOf<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var size = br.readLine().toInt()
    scores = Array(size) { mutableListOf() }
    check = Array(size) { 0 }

    repeat(size) { idx ->
        val score = br.readLine().split(" ").map { it.toInt() }
        scores[idx].addAll(score)
    }

    com(0)
    println(ans.min())
}


private fun com(startIndex: Int) {
    val start = check.withIndex().filter { it.value == 0 }.map { it.index }
    val link = check.withIndex().filter { it.value == 1 }.map { it.index }

    if (start.isNotEmpty() && link.isNotEmpty()) {
        val startValue = cal(start)
        val linkValue = cal(link)
        ans.add(abs(startValue - linkValue))
    }

    for (i in startIndex until check.size) {
        check[i] = 1
        com(i + 1)
        check[i] = 0
    }
}

private fun cal(list: List<Int>): Int {
    var rv = 0
    if (list.size == 1) {
        rv = 0
    } else if (list.size == 2) {
        rv = scores[list[0]][list[1]] + scores[list[1]][list[0]]
    } else {
        for (i in list.indices) {
            for (j in i + 1 until list.size) {
                rv += scores[list[i]][list[j]] + scores[list[j]][list[i]]
            }
        }
    }

    return rv
}