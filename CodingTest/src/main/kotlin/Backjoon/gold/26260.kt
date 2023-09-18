import java.io.*
import java.util.Collections
import java.util.*

private data class Node26260(val left: Int, val right: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var size = br.readLine().toInt()
    var nodes = br.readLine().split(" ").map { it.toInt() }
    var x = br.readLine().toInt()
    var tree = mutableListOf<Int>()

    Collections.replaceAll(nodes, -1, x)
    nodes = nodes.sorted()

    tree.add(nodes[nodes.size / 2])
    makeTreeArr(tree, nodes, 0, nodes.size - 1)

    println(tree.toList().toString())
    postorder(tree, 0)
}

//private fun makeTreeArr(tree: MutableList<Int>, nodes: List<Int>, left: Int, right: Int) {
//    var mid = (left + right) / 2
//
//    if(left < right && right - left > 1){
//        tree.add(nodes[(left + mid) / 2])
//        tree.add(nodes[(mid + 1 + right) / 2])
//
//        makeTreeArr(tree, nodes, left, mid)
//        makeTreeArr(tree, nodes, mid+1, right)
//    }
//}

private fun makeTreeArr(tree: MutableList<Int>, nodes: List<Int>, left: Int, right: Int) {
    var q: Queue<Node26260> = LinkedList()
    q.offer(Node26260(left, right))
    var mid = 0

    while (q.isNotEmpty()) {
        var node = q.poll()
        var left = node.left
        var right = node.right
        mid = (left + right) / 2

        if (left < right && right - left > 1) {
            tree.add(nodes[(left + mid) / 2])
            tree.add(nodes[(mid + 1 + right) / 2])

            q.offer(Node26260(left, mid))
            q.offer(Node26260(mid + 1, right))
        }
    }

}

private fun postorder(tree: MutableList<Int>, node: Int) {
    if (node in 0 until tree.size) {
        postorder(tree, 2 * node + 1)
        postorder(tree, 2 * node + 2)
        print("${tree[node]} ")
    }
}