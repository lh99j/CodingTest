import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
private var size = 0

private data class Fire20056(var x: Int, var y: Int, var m: Int, var s: Int, var d: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    size = n
    val fires = mutableListOf<Fire20056>()

    val map = Array<Array<Queue<Triple<Int, Int, Int>>>>(n) { Array(n) { LinkedList() } }

    repeat(m) {
        val inputs = br.readLine().split(" ").map { it.toInt() }
        val x = inputs[0] - 1
        val y = inputs[1] - 1

        map[x][y].offer(Triple(inputs[2], inputs[3], inputs[4]))
    }

    repeat(k) {idx ->
        //이동
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (map[i][j].isNotEmpty()) {
                    while (map[i][j].isNotEmpty()) {
                        val p = map[i][j].poll()

                        val l = move(i, j, p.second, p.third)
                        fires.add(Fire20056(l.first, l.second, p.first, p.second, p.third))
                    }
                }
            }
        }

        fires.forEach {
            map[it.x][it.y].offer(Triple(it.m, it.s, it.d))
        }
        fires.clear()

        //합치기
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (map[i][j].size > 1) {
                    var fs = map[i][j].size
                    var tm = 0
                    var ts = 0
                    var check = mutableListOf<Int>()

                    while (map[i][j].isNotEmpty()) {
                        val p = map[i][j].poll()

                        tm += p.first
                        ts += p.second
                        check.add(p.third)
                    }

                    var avgM = tm / 5
                    var avgS = ts / fs
                    var f1 = check.all { it % 2 == 0 }
                    var f2 = check.all { it % 2 != 0 }



                    if (avgM > 0) {
                        if (f1 || f2) {
                            map[i][j].offer(Triple(avgM, avgS, 0))
                            map[i][j].offer(Triple(avgM, avgS, 2))
                            map[i][j].offer(Triple(avgM, avgS, 4))
                            map[i][j].offer(Triple(avgM, avgS, 6))
                        } else {
                            map[i][j].offer(Triple(avgM, avgS, 1))
                            map[i][j].offer(Triple(avgM, avgS, 3))
                            map[i][j].offer(Triple(avgM, avgS, 5))
                            map[i][j].offer(Triple(avgM, avgS, 7))
                        }
                    }

                }
            }
        }
    }

    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j].isNotEmpty()) {
                while (map[i][j].isNotEmpty()) {
                    val p = map[i][j].poll()

                    ans += p.first
                }
            }
        }
    }

    println(ans)
}

private fun move(i: Int, j: Int, s: Int, d: Int): Pair<Int, Int> {
    var x = i
    var y = j
    var cnt = 0

    x = (x + (s * dx[d]) % size + size) % size
    y = (y + (s * dy[d]) % size + size) % size

    return x to y
}