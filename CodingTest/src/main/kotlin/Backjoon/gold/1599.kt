import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val map = mutableMapOf<String, String>()

    repeat(N) {
        val str = br.readLine()
        map[str] = str.replace()
    }

    println(map.entries.sortedBy { it.value }.joinToString("\n") { it.key })
}

private fun String.replace() = this.replace("ng", "l")
    .replace("k", "c")
    .replace("d", "D")
    .replace("e", "E")
    .replace("g", "F")
    .replace("h", "G")
    .replace("i", "H")
    .replace("l", "I")
    .replace("m", "J")
    .replace("n", "K")
    .replace("o", "M")
    .replace("p", "N")
    .replace("r", "O")
    .replace("s", "P")
    .replace("t", "Q")
    .replace("u", "R")
    .replace("w", "S")
    .replace("y", "T")