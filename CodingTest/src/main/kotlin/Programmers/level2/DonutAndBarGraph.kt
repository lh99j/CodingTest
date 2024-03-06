import java.util.*

class DonutAndBarGraph {
    fun solution(edges: Array<IntArray>): Array<Int> {
        var graph = Array<MutableList<Int>>(1000001) { mutableListOf() }
        var answer = arrayOf(0, 0, 0, 0)
        var inN = Array(1000001) { 0 }
        var outN = Array(1000001) { 0 }

        edges.forEach { (start, end) ->
            inN[end]++
            outN[start]++

            graph[start].add(end)
        }

        for (i in 0 until 1000001) {
            if (inN[i] == 0 && outN[i] > 1) {
                answer[0] = i

                break
            }
        }

        graph[answer[0]].forEach {
            answer[bfs(graph, it)]++
        }

        return answer
    }

    private fun bfs(graph: Array<MutableList<Int>>, start: Int): Int {
        val q: Queue<Int> = LinkedList()
        var n = 0

        q.offer(start)

        while (q.isNotEmpty()) {
            val p = q.poll()
            n++

            if (n > 1 && p == start) {
                return 1
            }

            graph[p].forEach {
                if (graph[it].size > 1) {
                    return 3
                }

                q.offer(it)
            }
        }

        return 2
    }
}