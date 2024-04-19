import java.io.BufferedReader
import java.io.InputStreamReader

private const val MAX = 1000000000
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val cnt = br.readLine().toInt()
    val bus = Array(size) { Array(size) { MAX } }

    repeat(size){
        bus[it][it] = 0
    }

    repeat(cnt) {
        val (s, d, c) = br.readLine().split(" ").map { it.toInt() }
        if(bus[s - 1][d - 1] > c){
            bus[s - 1][d - 1] = c
        }
    }

    for (k in 0 until size) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (bus[i][j] > bus[i][k] + bus[k][j]) {
                    bus[i][j] = bus[i][k] + bus[k][j];
                }
            }
        }
    }

    for(i in 0 until size){
        for(j in 0 until size){
            val cost = if(bus[i][j] >= MAX) 0 else bus[i][j]

            print("$cost ")
        }
        println()
    }
}