import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var size = br.readLine().toInt()
    var arr = mutableListOf<Long>()
    repeat(size){
        arr.add(br.readLine().toLong())
    }

    var ans = Array<Long>(arr.size) { 0 }

    var s = Stack<Long>()
    for (i in arr.indices) {
        while (s.isNotEmpty() && arr[s.peek().toInt()] <= arr[i]) {
            val p = s.pop()
            ans[p.toInt()] = i.toLong() - p - 1
        }
        s.push(i.toLong())
    }

    while (s.isNotEmpty()) {
        val p = s.pop()
        ans[p.toInt()] = arr.size - p - 1
    }

    println(ans.sum())
}