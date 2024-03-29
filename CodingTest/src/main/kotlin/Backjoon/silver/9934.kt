import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var floor = br.readLine().toInt()
    var inorderTraversal = br.readLine().split(" ").map { it.toInt() }

    var tree = Array<MutableList<Int>>(floor){ mutableListOf() }

    divideArray(inorderTraversal, tree, 0, inorderTraversal.size, 0)

    tree.forEach {
        it.forEach{
            print("$it ")
        }
        println()
    }
}

private fun divideArray(list: List<Int>, tree: Array<MutableList<Int>>, left: Int, right: Int, count: Int) {
    var mid = 0

    if (left < right) {
        mid = (left + right) / 2
        tree[count].add(list[mid])
        divideArray(list, tree, left, mid, count + 1);
        divideArray(list, tree, mid + 1, right, count + 1);
    }
}