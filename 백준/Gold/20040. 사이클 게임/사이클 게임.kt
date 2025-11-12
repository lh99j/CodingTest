import java.util.StringTokenizer
import kotlin.system.exitProcess

private var p = intArrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    p = IntArray (n) { it }

    repeat(m) { idx ->
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        if(find(x) == find(y)) {
            println(idx + 1)
            exitProcess(0)
        }

        union(x, y)
    }

    println(0)
}

private fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)

    p[px] = py
}

private fun find(x: Int): Int {
    if(x == p[x]) {
        return x
    }

    p[x] = find(p[x])
    return p[x]
}