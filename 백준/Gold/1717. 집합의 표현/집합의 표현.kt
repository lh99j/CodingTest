private lateinit var graph: IntArray

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    graph = IntArray(n + 1) { it }
    val sb = StringBuilder()

    repeat(m) {
        br.readLine().split(" ").map { it.toInt() }.let { (o, a, b) ->
            if (o == 0) {
                union(a, b)
            } else {
                val x = find(a)
                val y = find(b)

                sb.append(if(x != y) "NO" else "YES").append("\n")
            }
        }
    }

    println(sb)
}

private fun union(x: Int, y: Int) {
    if(x == y) return

    val px = find(x)
    val py = find(y)

    if(px == py) return

    graph[px] = py
}

private fun find(num: Int): Int {
    if(graph[num] == num) {
        return num
    }

    graph[num] = find(graph[num])
    return graph[num]
}