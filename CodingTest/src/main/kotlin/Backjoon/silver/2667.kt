import java.io.*
import java.util.*

private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(1, 0, -1, 0)
private var cnt = 0
private var num = 1
private var SIZE = 0
private var hashMap = mutableMapOf<Int, Int>()
private lateinit var visited: Array<Array<Int>>

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var size = br.readLine().toInt()
    SIZE = size
    var map = Array(size){Array(size){ 0 } }
    visited = Array(size){Array(size){ 0 } }

    for(i in 0 until size){
        val str = br.readLine()
        for(j in str.indices){
            map[i][j] = str[j].digitToInt()
        }
    }


    for(i in 0 until size){
        for(j in 0 until size){
            if(map[i][j] == 1)
                map = bfs(map, i, j)
        }
    }

//    for(i in 0 until size){
//        for(j in 0 until size){
//            print("${visited[i][j]} ")
//        }
//        println()
//    }

    var arr = hashMap.toList().map { it.second }.sorted()

    println(cnt)
    arr.forEach {
        println(it)
    }

}

private fun bfs(map: Array<Array<Int>>, x: Int, y: Int): Array<Array<Int>>{
    var q: Queue<Dot> = LinkedList<Dot>()
    var tempArr = map
    var tempNum = 0

    q.offer(Dot(x, y))
    visited[x][y] = num
    tempArr[x][y] = 0
    tempNum++


    while(q.isNotEmpty()){
        val temp = q.poll()

        for(i in 0 until 4){
            var nx = temp.x + dx[i]
            var ny = temp.y + dy[i]

            if(nx in 0 until SIZE && ny in 0 until SIZE && map[nx][ny] == 1 && visited[nx][ny] == 0){
                q.offer(Dot(nx, ny))
                visited[nx][ny] = num
                tempArr[nx][ny] = 0
                tempNum++
            }
        }
    }

    num++
    cnt++

    hashMap[cnt] = tempNum

    return tempArr
}