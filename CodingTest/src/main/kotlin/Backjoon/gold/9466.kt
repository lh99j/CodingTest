import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        var size = br.readLine().toInt()
        val inputs = br.readLine().split(" ").map { it.toInt() }
        var check: HashSet<Int> = hashSetOf()
        var ans = 0

        inputs.forEachIndexed { idx, value ->
            if (value - 1 == idx) {
                check.add(idx)
            } else if (idx !in check) {
                ans += bfs(inputs, check, idx)
            }

        }

        sb.append(ans).append("\n")
        
    }

    println(sb)
}

private fun bfs(inputs: List<Int>, check: HashSet<Int>, start: Int): Int {
    val q: Queue<Int> = LinkedList()
    val store = mutableListOf<Int>()
    var cycle = -1

    check.add(start)
    q.offer(start)
    store.add(start)
    var cnt = 0

    while (q.isNotEmpty()) {

        val p = q.poll()

        val next = inputs[p] - 1

        if (next == start) {
            return 0
        }

        if (next in check) {
            cycle = next
            break
        }

        if (next !in check) {
            q.offer(next)
            check.add(next)
            store.add(next)
            cnt++
        }

    }

    if(cycle != -1){
        var c = start

        var t = 0

        while(c != cycle){
            c = inputs[c] - 1
            t++
        }

        return t
    }

    return cnt
}