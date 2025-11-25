import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val inputs = IntArray(n)
    var s = 1
    var e = 1
    var t = 0
    var r = 0

    repeat (n) { i ->
        st = StringTokenizer(br.readLine())
        val v = st.nextToken().toInt()
        e = maxOf(v + 1, e)
        inputs[i] = v
    }

    inputs.sort()

    while(s < e) {
        val m = (s + e) / 2
        t = 1
        r = inputs[0]

        inputs.forEach {
            if(it - r >= m) {
                t++
                r = it
            }
        }

        if(t < c) {
            e = m
        } else {
            s = m + 1
        }
    }

    println(e - 1)
}
