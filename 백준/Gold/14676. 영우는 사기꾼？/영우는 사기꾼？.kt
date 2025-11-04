import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val buildings = IntArray(n + 1) { 0 }
    val prev = IntArray(n + 1) { 0 }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val s = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        graph[s].add(d)
        prev[d]++
    }

    repeat(k) {
        st = StringTokenizer(br.readLine())
        val o = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if(o == 1) {
            if(prev[b] > 0) {
                println("Lier!")
                return
            }
            buildings[b]++

            if(buildings[b] == 1) {
                for(next in graph[b]) {
                    prev[next]--
                }
            }
        } else {
            if(buildings[b] <= 0) {
                println("Lier!")
                return
            }

            buildings[b]--

            if(buildings[b] == 0) {
                for(next in graph[b]) {
                    prev[next]++
                }
            }
        }
    }

    println("King-God-Emperor")
}