import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

private var total = 0
fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var tree = Array<MutableList<Int>>(n + 1){ mutableListOf() }

    tree[0].add(0)

    repeat(n - 1){
        val (node1, node2) = br.readLine().split(" ").map { it.toInt() }

        tree[node1].add(node2)
        tree[node2].add(node1)
    }

//    dfs(tree, 1, 0)

    total = bfs(tree, 1)
    if(total % 2 == 0){
        println("No")
    }else{
        println("Yes")
    }
}

//private fun dfs(tree: Array<MutableList<Int>>, node: Int, cnt: Int){
//    visited[node] = 1
//
//    var isLeaf = true
//
//    tree[node].forEach {
//        if(visited[it] != 1){
//            dfs(tree, it, cnt + 1)
//            isLeaf = false
//        }
//    }
//
//    if(isLeaf) total += cnt
//}

//private fun dfs(tree: Array<MutableList<Int>>, node: Int, cnt: Int){
//    visited[node] = 1
//
//    tree[node].forEach {
//        if(visited[it] != 1){
//            dfs(tree, it, cnt + 1)
//        }
//    }
//
//    if(node != 1 && tree[node].size == 1){
//        total += cnt
//    }
//}

//bfs
//private fun bfs(tree: Array<MutableList<Int>>, node: Int): Int{
//    var q: Queue<Int> = LinkedList()
//    var total = 0
//
//    visited[node] = 1
//    q.offer(node)
//
//    while(q.isNotEmpty()){
//        var popNode = q.poll()
//
//        tree[popNode].forEach {
//            if(visited[it] == 0){
//                visited[it] = visited[popNode] + 1
//                q.offer(it)
//            }
//
//            if(tree[it].size == 1){
//                total += visited[it] - 1
//            }
//        }
//    }
//
//    return total
//}

private fun bfs(tree: Array<MutableList<Int>>, node: Int): Int{
    var q: Queue<Int> = LinkedList()
    var visited = HashSet<Int>()

    var total = 0
    var floor = 1

    visited.add(node)
    q.offer(node)

    while(q.isNotEmpty()){
        var size = q.size

        for(i in 0 until size){
            var temp = q.poll()

            tree[temp].forEach {
                if(it !in visited){
                    q.offer(it)
                    visited.add(it)
                }

                if(tree[it].size == 1){
                    total += floor
                }
            }
        }

        floor++
    }

    return total
}