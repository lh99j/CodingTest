import java.util.*

private var p = intArrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    
    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
    var ans = 0
    p = IntArray(v + 1) { it }
    repeat(e) {
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        
        pq.offer(Triple(x, y, v))
    }

    while(pq.isNotEmpty()) {
        val(x, y, v) = pq.poll()

        if(find(x) != find(y)) {
            union(x, y)
            ans += v
        }
    }

    println(ans)
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