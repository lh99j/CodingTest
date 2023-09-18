import java.io.*
import java.util.*

private data class Node26260(val left: Int, val right: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var size = br.readLine().toInt()
    var arr = br.readLine().split(" ").map { it.toInt() }
    var x = br.readLine().toInt()
    var tree = mutableListOf<Int>()
    var nodes = arr.map { if (it == -1) x else it }.sorted()

    tree.add(nodes[nodes.size / 2])
    postorder(nodes, 0, nodes.size)
}

private fun postorder(nodes: List<Int>, left: Int, right: Int) {
    val mid = (left + right) / 2

    if (left < right) {
        postorder(nodes, left, mid)
        postorder(nodes, mid + 1, right)
        print("${nodes[mid]} ")
    }
}