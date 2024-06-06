import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.round

val booms = Stack<Pair<Int, Int>>()
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var N = 0
private var M = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, c) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    val inputs = Array(n) { Array(m) { "" } }
    val records = Array(10) { Array(n) { Array(m) { "O" } } }

    repeat(n) { idx ->
        val strs = br.readLine()

        for (i in strs.indices) {
            if (strs[i].toString() == "O") {
                booms.push(idx to i)
            }

            inputs[idx][i] = strs[i].toString()
        }
    }

    if(c == 1){
        inputs.forEach {
            println(it.joinToString(""))
        }

        return
    }else if (c % 2 == 0) {
        inputs.forEach { it.fill("O") }

        inputs.forEach {
            println(it.joinToString(""))
        }

        return
    }

    repeat(2) { idx ->
        //전부 폭탄 처리
        inputs.forEach { it.fill("O") }

        //기존 폭탄 터지기
        boom(inputs, records[idx])
        setbooms(inputs)
    }

    if ((c - 1) % 4 == 0) {
        records[1].forEach {
            println(it.joinToString(""))
        }
    }else{
        records[0].forEach {
            println(it.joinToString(""))
        }
    }
}

private fun boom(map: Array<Array<String>>, records: Array<Array<String>>) {
    while (booms.isNotEmpty()) {
        val (x, y) = booms.pop()

        map[x][y] = "."
        records[x][y] = "."

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (validPosition(nx, ny)) {
                map[nx][ny] = "."
                records[nx][ny] = "."
            }
        }
    }
}

private fun setbooms(map: Array<Array<String>>) {
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == "O") {
                booms.push(i to j)
            }
        }
    }
}

private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until M