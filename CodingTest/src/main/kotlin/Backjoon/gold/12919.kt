import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val t = br.readLine()

    check(s, t)
    println(0)
}

private fun check(s: String, t: String) {
    if (s.length == t.length && s == t) {
        println(1)
        exitProcess(0)
    }

    if (s.length < t.length) {
        val tt = t.reversed()

        if(tt[tt.length - 1] == 'A' && t[t.length - 1] == 'A'){
            check(s, t.substring(0..t.length - 2))
        }else if(tt[tt.length - 1] == 'B' && t[t.length - 1] == 'B'){
            check(s, tt.substring(0..t.length - 2) )
        }else if(t[0] == 'B' && t[t.length - 1] == 'A'){
            check(s, t.substring(0..t.length - 2))
            check(s, tt.substring(0..t.length - 2) )
        }

    }
}