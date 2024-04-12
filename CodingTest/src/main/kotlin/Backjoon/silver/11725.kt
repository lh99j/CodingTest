import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

private lateinit var info: Array<Int>

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val map = Array<MutableList<Int>>(size + 1) { mutableListOf() }
    info = Array(size + 1){ 0 }
    val sb = StringBuilder()
    map[0].add(0)

    repeat(size - 1){
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        map[start].add(end)
        map[end].add(start)
    }

    bfs(map)

    for(i in 2..size){
         sb.append(info[i]).append("\n")
    }

    println(sb)
}

private fun bfs(map: Array<MutableList<Int>>){
    val q: Queue<Int> = LinkedList()
    var visited = HashSet<Int>()

    q.offer(1)
    visited.add(1)
    info[1] = 0

    while(q.isNotEmpty()){
        val p = q.poll()

        map[p].forEach {
            if(it !in visited){
                info[it] = p
                q.offer(it)
                visited.add(it)
            }
        }
    }
}