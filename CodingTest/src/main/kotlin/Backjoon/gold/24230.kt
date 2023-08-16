import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var colorNode = br.readLine().split(" ").map{ it.toInt() }
    var graph = Array<MutableList<Int>>(n){ mutableListOf() }
    var count = 0

    repeat(n - 1){
        var (node1, node2) = br.readLine().split(" ").map { it.toInt() }
        graph[node1 - 1].add(node2 - 1)
        graph[node2 - 1].add(node1 - 1)
    }

    if(colorNode[0] != 0){
        count++
    }

    print(bfs(graph, colorNode, count))
}

private fun bfs(graph: Array<MutableList<Int>>, colorNode: List<Int>, count: Int): Int{
    var q: Queue<Int> = LinkedList()
    val visited = HashSet<Int>()
    var cnt = count

    visited.add(0)
    q.offer(0)

    while(q.isNotEmpty()){
        var node = q.poll()

        graph[node].forEach {
            if(it !in visited){
                q.offer(it)
                visited.add(it)

                if(colorNode[it] != colorNode[node]){
                    cnt++
                }
            }
        }
    }

    return cnt
}
