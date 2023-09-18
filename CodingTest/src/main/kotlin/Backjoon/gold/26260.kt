import java.io.*
import java.util.*

private data class Node26260(val left: Int, val right: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var size = br.readLine().toInt()
    var arr = br.readLine().split(" ").map { it.toInt() }
    var x = br.readLine().toInt()
    var tree = mutableListOf<Int>()
    var nodes = arr.map{ if(it == -1) x else it }.sorted()

    tree.add(nodes[nodes.size / 2])
    buildTree(tree, nodes, 0, nodes.size - 1)
    postorder(tree, 0)
}

private fun buildTree(tree: MutableList<Int>, nodes: List<Int>, left: Int, right: Int) {
    val q: Queue<Node26260> = LinkedList()
    q.offer(Node26260(left, right))

    while (q.isNotEmpty()) {
        val node = q.poll()
        val mid = (node.left + node.right) / 2

        if (node.left < node.right && node.right - node.left > 1) {
            tree.add(nodes[(node.left + mid) / 2])
            tree.add(nodes[(mid + 1 + node.right) / 2])

            q.offer(Node26260(node.left, mid))
            q.offer(Node26260(mid + 1, node.right))
        }
    }

}

private fun postorder(tree: MutableList<Int>, node: Int) {
    if (node in tree.indices) {
        postorder(tree, 2 * node + 1)
        postorder(tree, 2 * node + 2)
        print("${tree[node]} ")
    }
}