import java.io.*
import java.lang.StringBuilder

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var (a, b) = br.readLine().split(" ").map { it.toBigInteger()}

    println(a + b)
}
