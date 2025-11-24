import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val k = st.nextToken().toInt()
    val n = st.nextToken().toLong()
    val inputs = LongArray(k)
    var s: Long = 1
    var e: Long = 0
    var t: Long = 0

    repeat(k) { i ->
        st = StringTokenizer(br.readLine())
        val v = st.nextToken().toLong()
        e = maxOf(e, v + 1)
        inputs[i] = v
    }

    while(s < e) {
        val m: Long = (s + e) / 2
        t = 0

        inputs.forEach {
            t += it / m
        }

        if(t < n) {
            e = m
        } else {
            s = m + 1
        }
    }

    println(e - 1)
}
