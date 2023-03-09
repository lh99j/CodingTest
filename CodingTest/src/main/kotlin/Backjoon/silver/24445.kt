import java.io.*
import java.util.*

private var visited = mutableListOf<Int>()
private var count = 0

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, m, r) = br.readLine().split(" ").map { it.toInt() }


    var bfsMat = Array<MutableList<Int>>(n){ mutableListOf() }

    repeat(m){
        var (u, v) = br.readLine().split(" ").map { it.toInt() - 1 }
        bfsMat[u].add(v)
        bfsMat[v].add(u)
    }

    bfsMat.forEach {
        it.sortDescending()
    }

    visited = MutableList(n){ 0 }

    bfs(bfsMat, r - 1)

    visited.forEach {
        println(it)
    }
}

fun bfs(bfsMat: Array<MutableList<Int>>, r: Int){

    var q: Queue<Int> = LinkedList<Int>()

    q.clear()

    visited[r] = ++count

    q.offer(r)

    while(q.isNotEmpty()){
        var temp  = q.poll()

        bfsMat[temp].forEach {
            if(visited[it] == 0){
                visited[it] = ++count
                q.offer(it)
            }
        }
    }
}