import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val boards = mutableMapOf<Int, Int>()
private var visited = Array(101) { -1 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (l, s) = br.readLine().split(" ").map { it.toInt() }

    //사다리
    repeat(l + s) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        boards[x] = y
    }

    println(bfs())
}

private fun bfs(): Int {
    val q: Queue<Int> = LinkedList()
    visited[1] = 0
    q.offer(1)

    while (q.isNotEmpty()) {
        val p = q.poll()

        for (i in 1..6) {
            if (p + i > 100 || visited[p + i] != -1)
                continue

            if(boards.containsKey(p + i)){ //사다리, 뱀의 위치를 만나면
                if(visited[boards[p + i]!!] != -1){
                    continue
                }
                visited[boards[p + i]!!] = visited[p] + 1
                q.offer(boards[p + i])
            }else { //사다리, 뱀이 아니라면
                visited[p + i] = visited[p] + 1
                q.offer(p + i)
            }

        }
    }

    return visited[100]
}