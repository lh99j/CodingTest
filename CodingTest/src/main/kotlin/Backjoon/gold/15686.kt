import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import java.util.StringTokenizer

private var chicken = mutableListOf<Pair<Int, Int>>()
private var house = mutableListOf<Pair<Int, Int>>()
private lateinit var visited: Array<Boolean>
private var cnt = 0
private var min = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (N, c) = readLine().split(" ").map { it.toInt() }
    cnt = c

    repeat(N) { i ->
        val st = StringTokenizer(readLine())

        for (j in 0 until N) {
            val num = st.nextToken().toInt()

            if (num == 1) {
                house.add(Pair(i, j))
            } else if (num == 2) {
                chicken.add(Pair(i, j))
            }
        }
    }

    visited = Array(chicken.size) { false }


    back(0, 0)
    println(min)

}

private fun back(start: Int, depth: Int) {
    if (depth == cnt) {
        var minValue = 0

        for (i in house.indices) {
            val (hx, hy) = house[i]
            var m = Int.MAX_VALUE

            for (j in visited.indices) {
                if(visited[j]) {
                    val (cx, cy) = chicken[j]
                    var dis = abs(cx - hx) + abs(cy - hy)
                    m = minOf(m, dis)
                }
            }

            minValue += m
        }

        min = minOf(min, minValue)

        return
    }

    for (i in start until visited.size) {
        if (visited[i])
            continue

        visited[i] = true
        back(i + 1, depth + 1)
        visited[i] = false
    }
}