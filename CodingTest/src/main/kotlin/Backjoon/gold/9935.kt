import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var str = br.readLine()
    val boom = br.readLine()

    val sb = StringBuilder()
    for (i in str.indices) {
        sb.append(str[i])
        var isSame = true

        if (sb.length >= boom.length) {
            for (j in boom.indices) {
                if (sb[sb.length - boom.length + j] != boom[j]) {
                    isSame = false
                }
            }

            if (isSame) {
                sb.delete(sb.length - boom.length, sb.length)
            }
        }
    }

    println(sb.ifEmpty { "FRULA" })
}