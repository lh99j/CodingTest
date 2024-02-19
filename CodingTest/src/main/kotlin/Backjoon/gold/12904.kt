import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var s = br.readLine()
    var t = br.readLine()

    while (s.length < t.length) {
        if (t[t.length - 1] == 'A') {
            t = t.substring(0..t.length - 2)
        } else {
            t = t.substring(0..t.length - 2)
            t = t.reversed()
        }
    }

    println(if(s == t) 1 else 0)
}