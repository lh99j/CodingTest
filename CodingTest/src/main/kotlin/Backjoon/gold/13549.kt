import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

private var s = 0
private var d = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ts, td) = br.readLine().split(" ").map { it.toInt() }
    s = ts
    d = td

    println(bfs())
}

private fun bfs(): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = HashSet<Int>()

    q.offer(s to 0)
    visited.add(s)

    while(q.isNotEmpty()){
        val (node, time) = q.poll()

        if(node == d){
            return time
        }

        if(node * 2 in 0..200000 && (node * 2) !in visited){
            visited.add(node * 2)
            q.offer(node * 2 to time)
        }

        if(node - 1 in 0..200000 && (node - 1) !in visited){
            visited.add(node - 1)
            q.offer(node - 1 to time + 1)
        }

        if(node + 1 in 0..200000 && (node + 1) !in visited){
            visited.add(node + 1)
            q.offer(node + 1 to time + 1)
        }
    }

    return -1
}