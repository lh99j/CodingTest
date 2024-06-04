import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import javax.print.attribute.standard.MediaSize.Other
import kotlin.system.exitProcess

// 0 : W, 1 : N, 2 : E, 3 : S -> [W, N, E, S]
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private data class Robot2174(var x: Int, var y: Int, var d: Int) {
    fun execute(order: String) {
        when (order) {
            "F" -> goForward()
            "L" -> turnLeft()
            "R" -> turnRight()
        }
    }

    private fun goForward() {
        x += dx[d]
        y += dy[d]
    }

    private fun turnLeft() {
        d = if (d - 1 < 0) 3 else --d
    }

    private fun turnRight() {
        d = if (d + 1 > 3) 0 else ++d
    }
}

private var A = 0
private var B = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    A = a
    B = b
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val robots = mutableListOf<Robot2174>()
    val robotPosition = Array(A + 1) { IntArray(B + 1) { -1 } }
    var error = false

    repeat(N) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val d = mappingDirection(st.nextToken())
        robots.add(Robot2174(x, y, d))
        robotPosition[x][y] = robots.size - 1
    }


    for (i in 0 until M) {
//        robotPosition.forEach {
//            println(it.joinToString(" "))
//        }
//        println("${robots[0]}, $error")
//        println()

        val st = StringTokenizer(br.readLine())
        val robotNum = st.nextToken().toInt() - 1
        val order = st.nextToken()
        val cnt = st.nextToken().toInt()

        if (error)
            continue

        for (j in 0 until cnt) {
            val (cx, cy, cd) = robots[robotNum]
            robotPosition[cx][cy] = -1

            robots[robotNum].execute(order)

            val (nx, ny, nd) = robots[robotNum]

            // WALL
            if (!validPosition(nx, ny)) {
                bw.write("Robot ${robotNum + 1} crashes into the wall\n")
                error = true
                break
            }

            if (robotPosition[nx][ny] != -1) {
                var cR = robotPosition[nx][ny] + 1
                bw.write("Robot ${robotNum + 1} crashes into robot $cR\n")
                error = true
                break
            }

            robotPosition[nx][ny] = robotNum
        }
    }

    if (!error) {
        bw.write("OK")
    }

    bw.flush()
    bw.close()
}

private fun mappingDirection(direction: String): Int {
    return when (direction) {
        "W" -> 0
        "N" -> 1
        "E" -> 2
        "S" -> 3
        else -> -1
    }
}

private fun validPosition(x: Int, y: Int) = x in 1..A && y in 1..B