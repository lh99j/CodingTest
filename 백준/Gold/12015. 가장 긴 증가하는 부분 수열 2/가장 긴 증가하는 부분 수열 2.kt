import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val l = mutableListOf<Int>()

    while (st.hasMoreTokens()) {
        val v = st.nextToken().toInt()
        val c = l.size - 1

        if(l.isEmpty() || l[c] < v) {
            l.add(v)
//            println("lis : $l")
            continue
        }

        var s = 0
        var e = c + 1

        while(s < e) {
            val m = (s + e) / 2

            if(v < l[m]) {
                e = m
            } else {
                s = m + 1
            }
        }

        if(e > 0 && l[e - 1] == v) continue
        l[e] = v

//        println("lis : $l")
    }

    println(l.size)
}
