import kotlin.math.*

private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(1, 0, -1, 0)
fun main() {
    val br = System.`in`.bufferedReader()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val r1 = inputs[0]
    val c1 = inputs[1]
    val r2 = inputs[2]
    val c2 = inputs[3]

    val area = Array(abs(r2 - r1) + 1) { IntArray(abs(c2 - c1) + 1) { 0 } }

    var cx = 0
    var cy = 0
    var value = 1
    var maxLen = 0
    var cnt = 1
    var correct = 0
    val total = area.size * area[0].size

    if (0 in r1..r2 && 0 in c1..c2) {
        correct++
        area[abs(r1)][abs(c1)] = 1
    }

    while (true) {
        val direction = if (cnt == 1) 0 else (cnt - 1) % 4
        val repeat = (cnt + 1) / 2

        for (i in 1..repeat) {
            cx += dx[direction]
            cy += dy[direction]

            value++

            if (cx in r1..r2 && cy in c1..c2) {
                area[cx - r1][cy - c1] = value
                correct++
                maxLen = value
            }
        }

        //종료 조건
        if (correct >= total) {
            break
        }

        cnt++
    }

    area.forEach {
        println(it.joinToString(" ") { " ".repeat(maxLen.toString().length - it.toString().length) + it.toString() })
    }
}