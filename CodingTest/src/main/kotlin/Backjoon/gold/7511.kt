import java.io.*
import java.util.StringTokenizer

private lateinit var ans: IntArray
private lateinit var st: StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    st = StringTokenizer(br.readLine())
    val tc = st.nextToken().toInt()

    repeat(tc) { testCase ->
        bw.write("Scenario ${testCase + 1}:\n")

        st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()

        st = StringTokenizer(br.readLine())
        val K = st.nextToken().toInt()

        ans = IntArray(N) { it }

        repeat(K) {
            st = StringTokenizer(br.readLine())
            val start = st.nextToken().toInt()
            val end = st.nextToken().toInt()

            union(start, end)
        }

        println(ans.toList())

        st = StringTokenizer(br.readLine())
        val M = st.nextToken().toInt()

        repeat(M) {
            st = StringTokenizer(br.readLine())
            val start = st.nextToken().toInt()
            val end = st.nextToken().toInt()

            val startF = find(start)
            val endF = find(end)

            bw.write("${if(startF == endF) 1 else 0}\n")
        }

        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

private fun find(num: Int): Int{
    if(num == ans[num]) return num
    else return find(ans[num])
}

private fun union(a: Int, b: Int){
    val aParent = find(a)
    val bParent = find(b)

    if (aParent < bParent) {
        ans[bParent] = aParent
    } else if (bParent < aParent) {
        ans[aParent] = bParent
    }
}