import java.io.*
import java.util.*

private lateinit var team: IntArray
private lateinit var visited: BooleanArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val sb = StringBuilder()
    team = IntArray(n + 1) { -1 }
    visited = BooleanArray(n + 1) { false }

    graph[0].add(0)
    repeat(n) { idx ->
        val inputs = br.readLine().trim().split(" ").map { it.toInt() }
        val size = inputs[0]

        for (i in 1..size) {
            graph[idx + 1].add(inputs[i])
        }
    }

    for (i in 1..n) {
        separateTeam(graph, i)
    }

    val team1List = team.toList().mapIndexedNotNull { index, value -> if (value == 0) index else null }.toMutableList()
    val team2List = team.toList().mapIndexedNotNull { index, value -> if (value == 1) index else null }.toMutableList()

    if(team2List.isEmpty()){
        val last = team1List.removeLast()
        team2List.add(last)
    }

    println(team1List.size)
    println(team1List.joinToString(" "))
    println(team2List.size)
    println(team2List.joinToString(" "))
}

private fun separateTeam(graph: Array<MutableList<Int>>, start: Int) {
    val q: Queue<Int> = LinkedList()

    q.offer(start)

    if (!visited[start]) {
        team[start] = 0
        visited[start] = true
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        graph[cur].forEach { next ->
            if (!visited[next]) {
                team[next] = getOppositeTeam(team[cur])
                visited[next] = true
                q.offer(next)
            }
        }
    }
}

private fun getOppositeTeam(value: Int) = if (value == 0) 1 else 0
