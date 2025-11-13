import java.util.StringTokenizer

private var p = mutableMapOf<String, String>()
private var c = mutableMapOf<String, Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val sb = StringBuilder()

    repeat(n) { tc ->
        st = StringTokenizer(br.readLine())
        val t = st.nextToken().toInt()
        p.clear()
        c.clear()

        repeat(t) {
            st = StringTokenizer(br.readLine())
            val x = st.nextToken()
            val y = st.nextToken()

            union(x, y)

            sb.append(c[find(x)]).append("\n")
        }
    }

    println(sb)
}

private fun union(x: String, y: String) {
    val px = find(x)
    val py = find(y)

    if(px == py) return

    p[px] = py

    val total = c.getOrDefault(px, 1) + c.getOrDefault(py, 1)
    c[px] = total
    c[py] = total
}

private fun find(x: String): String {
    if(p[x] == null) {
        p[x] = x
    }

    if(x == p[x]) {
        return x
    }

    p[x] = find(p[x]!!)
    return p[x]!!
}