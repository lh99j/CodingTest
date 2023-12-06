import java.util.*
import kotlin.collections.HashSet

class ReturnArmy {
    private lateinit var distance: Array<Int>

    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): List<Int> {
        val answer = mutableListOf<Int>()
        val tree = Array<MutableList<Int>>(n + 1) { mutableListOf() }

        tree[0].add(0)

        roads.forEach { (start, end) ->
            tree[start].add(end)
            tree[end].add(start)
        }

        distance = Array(n + 1) { -1 }
        bfs(tree, destination)

        sources.forEach {
            answer.add(distance[it])
        }

        return answer
    }

    private fun bfs(tree: Array<MutableList<Int>>, destination: Int) {
        val q: Queue<Int> = LinkedList()
        val visited = HashSet<Int>()

        q.offer(destination)
        visited.add(destination)
        distance[destination] = 0

        while (q.isNotEmpty()) {
            val t = q.poll()

            tree[t].forEach {
                if (it !in visited) {
                    q.offer(it)
                    visited.add(it)
                    distance[it] = distance[t] + 1
                }
            }
        }
    }
}