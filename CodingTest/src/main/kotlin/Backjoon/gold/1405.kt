import java.io.BufferedReader
import java.io.InputStreamReader

private var percent = mutableListOf<Double>()
private var size = 0
private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)
private var sum = 0.0
private var store = mutableListOf<Pair<Int, Int>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    size = input[0]
    for (i in 1 until input.size) {
        percent.add(input[i].toDouble() / 100)
    }

    store.add(0 to 0)
    per(0, 0, 0, 1.0)
    println(sum)
}

private fun per(cnt: Int, cx: Int, cy: Int, pp: Double) {
    if (cnt == size) {
        sum += pp
        return
    }

    for (i in 0..3) {
        if (percent[i] != 0.0) {
            var x = cx
            var y = cy

            x += dx[i]
            y += dy[i]

            val p = x to y

            if (p !in store) {
                store.add(x to y)
                per(cnt + 1, x, y, percent[i] * pp)
                store.removeLast()
            }
        }
    }
}