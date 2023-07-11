import java.util.*
import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, s, p) = br.readLine().split(" ").map { it.toInt() }
    val map = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }
    var answerArr = mutableListOf<Int>()

    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        map[a].add(b)
        map[b].add(a)
    }

    for (i in 1 until s + 1) {
        var bfsValue = bfs(map, i, p)
        answerArr.add(bfsValue)
    }

    val sortedAnswerArr = answerArr.sorted()
    var temp = sortedAnswerArr[0] + sortedAnswerArr[1] + 1
    println(n - temp)
}

private fun bfs(map: Array<MutableSet<Int>>, startPoint: Int, endPoint: Int): Int {
    val q: Queue<Int> = LinkedList()
    val visited = HashSet<Int>()

    q.offer(startPoint)
    visited.add(startPoint)

    var distance = 0

    while (q.isNotEmpty()) {
        val size = q.size

        for (i in 0 until size) {
            val cur = q.poll()

            if (cur == endPoint) {
                return distance
            }

            map[cur].forEach {
                if (it !in visited) {
                    visited.add(it)
                    q.offer(it)
                }
            }
        }

        distance++
    }

    return -1
}