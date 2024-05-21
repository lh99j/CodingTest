import java.io.*
import java.util.StringTokenizer
import java.util.*
import kotlin.collections.ArrayDeque

private data class Node11003(val value: Int, val index: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val L = st.nextToken().toInt()
    val d: ArrayDeque<Node11003> = ArrayDeque()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(br.readLine())

    for (i in 0 until N) {
        val value = st.nextToken().toInt()

        while (d.isNotEmpty() && d.last().value > value) {
            d.removeLast()
        }

        d.addLast(Node11003(value, i))

        if(d.first().index < i - L + 1){
            d.removeFirst()
        }

        bw.write("${d.first().value} ")

    }

    bw.flush()
    bw.close()
}