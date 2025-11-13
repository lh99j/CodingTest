import java.util.StringTokenizer

private var p = intArrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val m = st.nextToken().toInt()
    p = IntArray(n + 1) { it }
    val e = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val o = st.nextToken()
        val p = st.nextToken().toInt()
        val q = st.nextToken().toInt()

        if(o == "E") {
            e[p].add(q)
            e[q].add(p)
        } else {
            union(p, q)
        }
    }

    e.forEach {
        if (it.isNotEmpty()) {
            for(i in 0 until it.size) {
                for(j in i + 1 until it.size) {
                    union(it[i], it[j])
                }
            }
        }
    }


    val new = p.copyOf()
    p.forEachIndexed { idx, value ->
        new[idx] = find(value)
    }

    println(new.toSet().size - 1)
}

private fun find(x: Int): Int {
    if(x == p[x])
        return x

    p[x] = find(p[x])
    return p[x]
}

private fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)

    p[px] = py
}
