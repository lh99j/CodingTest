import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val inputs = LongArray(10) { 0 }
    val N = st.nextToken().toInt()
    var K = st.nextToken().toLong()
    var ans: Long = 0

    repeat(N) { idx ->
        st = StringTokenizer(br.readLine())
        inputs[idx] = st.nextToken().toLong()
    }

    for (i in N - 1 downTo 0) {
        if(K >= inputs[i]) {
            ans += K / inputs[i]
            K %= inputs[i]
        }
    }

    println(ans)
}