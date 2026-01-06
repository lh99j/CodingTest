import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    var time = Array(cnt){ st.nextToken().toInt() }.sorted()

    var result = 0
    var ctime = 0

    time.forEach {
        result += it + ctime
        ctime += it
    }

    println(result)

}