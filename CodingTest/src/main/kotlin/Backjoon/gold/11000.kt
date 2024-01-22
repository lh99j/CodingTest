import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()

    var check = PriorityQueue<Int>()
    var ans = 0

    repeat(cnt) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        if (check.isEmpty()) {
            ans++
            check.add(y)
        } else {
            if (check.any { it <= x }) {
                ans++
                check.add(y)
            }
        }
    }

    println(ans)

}