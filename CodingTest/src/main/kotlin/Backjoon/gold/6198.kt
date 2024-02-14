import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val input = mutableListOf<Long>()
    val ans = Array<Long>(cnt) { 0 }
    val s = Stack<Long>()

    repeat(cnt) {
        input.add(br.readLine().toLong())
    }

    for (i in 0 until cnt) {
        while (s.isNotEmpty() && input[s.peek().toInt()] <= input[i]) {
            val p = s.pop()
            ans[p.toInt()] = i - p - 1
        }
        s.push(i.toLong())
    }

    while(s.isNotEmpty()){
        val p = s.pop()
        ans[p.toInt()] = cnt - p - 1
    }

    println(ans.sum())
}