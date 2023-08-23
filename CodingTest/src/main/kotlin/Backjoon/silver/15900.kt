import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var visited: Array<Int>
private var total = 0
fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var tree = Array<MutableList<Int>>(n + 1){ mutableListOf() }

    visited = Array(n + 1){ 0 }

    tree[0].add(0)

    repeat(n - 1){
        val (node1, node2) = br.readLine().split(" ").map { it.toInt() }

        tree[node1].add(node2)
        tree[node2].add(node1)
    }

    dfs(tree, 1, 0)

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

private fun dfs(tree: Array<MutableList<Int>>, node: Int, cnt: Int){
    visited[node] = 1

    tree[node].forEach {
        if(visited[it] != 1){
            dfs(tree, it, cnt + 1)
        }
    }

    if(node != 1 && tree[node].size == 1){
        total += cnt
    }
}