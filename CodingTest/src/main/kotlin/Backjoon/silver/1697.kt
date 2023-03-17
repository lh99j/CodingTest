import java.io.*
import java.lang.Integer.max
import java.util.*

private var visited: MutableList<Int> = mutableListOf()
private var MAX = 100_000

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (start, end) = br.readLine().split(" ").map { it.toInt() }
    var max = max(start, end)
    var array = Array<MutableList<Int>>(MAX + 1) { mutableListOf() }

    visited = MutableList(MAX + 1) { 0 }

    for (i in 0..MAX) {
        if (i - 1 in 0..MAX) {
            array[i].add(i - 1)
        }

        if (i + 1 in 0..MAX) {
            array[i].add(i + 1)
        }

        if (i * 2 in 0..MAX) {
            array[i].add(i * 2)
        }
    }


    array.forEach {
        it.sort()
    }


    bfs(array, start, end)

    println(visited[end] - 1)

}

private fun bfs(array: Array<MutableList<Int>>, start: Int, end: Int) {
    var q: Queue<Int> = LinkedList<Int>()

    visited[start] = 1
    q.offer(start)

    while (q.isNotEmpty()) {
        var temp = q.poll()

        array[temp].forEach {
            if (visited[it] == 0) {
                visited[it] = visited[temp] + 1
                q.offer(it)
            }

        }
    }
}