import java.util.StringTokenizer

private var graph = intArrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    graph = IntArray(n + 1) { it }
    val sb = StringBuilder()

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val o = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        if (o == 0) {
            union(x, y)
        } else {
            sb.append(if(find(x) != find(y)) "NO" else "YES").append("\n")
        }
    }

    println(sb)
}

private fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)

    graph[px] = py
}

private fun find(num: Int): Int {
    if(graph[num] == num) {
        return num
    }

    graph[num] = find(graph[num])
    return graph[num]
}