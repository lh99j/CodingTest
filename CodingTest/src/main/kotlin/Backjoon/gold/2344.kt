import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

//상, 하, 좌, 우
private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)
private var N = 0
private var M = 0
private var size = 0
private lateinit var lights: Array<Triple<Int, Int, Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    val map = Array<MutableList<Int>>(N + 2) { mutableListOf() }
    size = N * 2 + M * 2
    lights = Array(size + 1) { Triple(0, 0, 0) }
    val sb = StringBuilder()

    repeat(N) { idx ->
        val inputs = br.readLine().split(" ").map { it.toInt() }
        map[idx + 1].addAll(inputs)
    }

    initMap(map)

    repeat(size) { idx ->
        var (x, y, d) = lights[idx + 1]

        while(x in 1..N && y in 1..M){
            if(map[x][y] == 0){
                x += dx[d]
                y += dy[d]
            }else{
                d = reflect(d)
                x += dx[d]
                y += dy[d]
            }
        }

        sb.append(map[x][y]).append(" ")
    }

    println(sb)
}

private fun reflect(currentDirection: Int): Int {
    return when (currentDirection) {
        0 -> 3
        1 -> 2
        2 -> 1
        else -> 0
    }
}

private fun initMap(map: Array<MutableList<Int>>) {
    val temp = List(M + 2) { 0 }

    map[0].addAll(temp)
    map[N + 1].addAll(temp)

    for (i in 1..N) {
        map[i].add(0, 0)
        map[i].add(M + 1, 0)
    }

    for (i in map.indices) {
        if (i == 0) {
            var total = size
            for (j in 1..M) {
                lights[total] = Triple(1, j, 1)
                map[i][j] = total--
            }
        } else if (i == map.size - 1) {
            var t = i
            for (j in 1..M) {
                lights[t] = Triple(N, j, 0)
                map[i][j] = t++
            }
        } else {
            var value = size - M - i + 1

            map[i][0] = i
            map[i][M + 1] = value
            lights[i] = Triple(i, 1, 3)
            lights[value] = Triple(i, M, 2)
        }
    }
}