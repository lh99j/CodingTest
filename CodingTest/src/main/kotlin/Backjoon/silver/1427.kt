import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().toString().toList().sortedDescending().joinToString(separator = "").let { print(it) }
}