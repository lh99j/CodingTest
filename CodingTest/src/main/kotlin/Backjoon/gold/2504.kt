import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val s = Stack<String>()
    var idx = 0

    checkValidStr(str)

    var i = 0
    while (i < str.length) {
        if (str[i] == '(') {
            if (str.substring(i, i + 2) == "()") {
                s.push("2")
                i++
            } else {
                s.push("(")
            }
        } else if (str[i] == '[') {
            if (str.substring(i, i + 2) == "[]") {
                s.push("3")
                i++
            } else {
                s.push("[")
            }
        } else if (str[i] == ')') {
            calValue(s, "(")
        } else if (str[i] == ']') {
            calValue(s, "[")
        }
        i++
    }

    println(s.sumOf { it.toInt() })

}

private fun calValue(s: Stack<String>, w: String) {
    var value = 0

    while (true) {
        val t = s.pop()
        if (t == w) {
            var v = 0
            if (w == "[") {
                v = value * 3
            } else {
                v = value * 2
            }
            s.push(v.toString())
            return
        } else {
            value += t.toInt()
        }
    }
}

private fun checkValidStr(str: String) {
    val s = Stack<Char>()
    for (i in str) {
        if (i == '(' || i == '[') {
            s.push(i)
        } else {
            if (s.isEmpty() || (i == ')' && s.peek() != '(') || (i == ']' && s.peek() != '[')) {
                println("0")
                exitProcess(0)
            } else {
                s.pop()
            }
        }
    }
    if (s.isNotEmpty()) {
        println("0")
        exitProcess(0)
    }
}