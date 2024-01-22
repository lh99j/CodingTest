import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    var tL = mutableListOf<Pair<Int, Int>>()
    var pQ = PriorityQueue<Int>()

    repeat(cnt) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        tL.add(x to y)
    }

    tL.sortedWith(compareBy({ it.first }, { it.second })).forEach {
        if(pQ.isEmpty()){
            pQ.offer(it.second)
        }else{
            val p = pQ.peek()
            if(p <= it.first){
                pQ.poll()
            }
            pQ.offer(it.second)
        }
    }

    println(pQ.size)
}