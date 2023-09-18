import java.io.*
import java.lang.StringBuilder
import java.util.*

private data class Node26260(val left: Int, val right: Int)
private var sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var size = br.readLine().toInt()
    var arr = br.readLine().split(" ").map { it.toInt() }
    var x = br.readLine().toInt()
    var nodes = arr.map { if (it == -1) x else it }.sorted()

    postorder(nodes, 0, nodes.size)
    println(sb)
}

private fun postorder(nodes: List<Int>, left: Int, right: Int) {
    val mid = (left + right) / 2

    if (left < right) {
        postorder(nodes, left, mid)
        postorder(nodes, mid + 1, right)
        sb.append(nodes[mid]).append(" ")
    }
}

//private fun buildTree(tree: MutableList<Int>, nodes: List<Int>, left: Int, right: Int) {
//    val q: Queue<Node26260> = LinkedList()
//    q.offer(Node26260(left, right))
//
//    while (q.isNotEmpty()) {
//        val node = q.poll()
//        val mid = (node.left + node.right) / 2
//
//        if (node.left < node.right && node.right - node.left > 1) {
//            tree.add(nodes[(node.left + mid) / 2])
//            tree.add(nodes[(mid + 1 + node.right) / 2])
//
//            q.offer(Node26260(node.left, mid))
//            q.offer(Node26260(mid + 1, node.right))
//        }
//    }
//
//}