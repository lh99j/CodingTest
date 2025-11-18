import java.io.BufferedWriter
import kotlin.math.pow

private var map: Array<Array<String>> = arrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    map = Array(n) { Array(n) { " " } }
    val sb = StringBuilder()

    star(n, 0, 0)

    for(i in 0 until n) {
        for(j in 0 until n) {
            sb.append(map[i][j])
        }
        sb.append("\n")
    }

    println(sb)
}

private fun star(n: Int, x: Int, y: Int) {
    if(n == 1) {
        map[x][y] = "*"
        return
    }

    val divide = n / 3

    for(i in 0 until 3) {
        for(j in 0 until 3) {
            if(i == 1 && j == 1) continue

            star(divide, x + (divide * i), y + (divide * j))
        }
    }
}