import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val op = charArrayOf('+', '-', '*', '/', '(', ')')
    val p = charArrayOf('(', ')')
    val str = br.readLine()
    val s = Stack<Char>()
    val sb = StringBuilder()

    str.forEach {
        when (it) {
            in 'A'..'Z' -> sb.append(it)
            '(' -> s.push(it)
            '*', '/' -> {
                while (s.isNotEmpty() && s.peek() != '(' && !(s.peek() == '+' || s.peek() == '-')) {
                    sb.append(s.pop())
                }
                s.push(it)
            }

            '+', '-' -> {
                while (s.isNotEmpty() && s.peek() != '(') {
                    sb.append(s.pop())
                }
                s.push(it)
            }

            ')' -> {
                while (s.peek() != '(') {
                    sb.append(s.pop())
                }

                s.pop()
            }
        }
    }

    while (s.isNotEmpty()) {
        sb.append(s.pop())
    }

    println(sb)
}