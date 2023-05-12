import java.io.*
import java.util.*

private var dx = intArrayOf(0, -1, 0, 1, -1, 1, 1, -1)
private var dy = intArrayOf(1, 0, -1, 0, 1, 1, -1, -1)

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true){
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        var islandArr = Array<MutableList<Int>>(h){ mutableListOf() }
        var answer = 0

        if(w == 0 && h == 0){
            break
        }

        for(i in 0 until h){
            val numArr = br.readLine().split(" ").map { it.toInt() }
            islandArr[i].addAll(numArr)
        }

        val visitedArr = Array(h){Array(w){ 0 } }
        for(i in islandArr.indices){
            for(j in 0 until islandArr[0].size){
                if(islandArr[i][j] == 1 && visitedArr[i][j] == 0){
                    bfs(islandArr, visitedArr, i, j)
                    answer++
                }
            }
        }

        println(answer)
    }
}

private fun bfs(arr: Array<MutableList<Int>>, visitedArray: Array<Array<Int>>, x: Int, y: Int){
    val q: Queue<Dot> = LinkedList()

    q.offer(Dot(x, y))
    visitedArray[x][y] = 1

    while (q.isNotEmpty()){
        val temp = q.poll()

        for(i in 0 until 8){
            val nx = temp.x + dx[i]
            val ny = temp.y + dy[i]

            if(nx in arr.indices && ny in 0 until arr[0].size && arr[nx][ny] == 1 && visitedArray[nx][ny] == 0){
                q.offer(Dot(nx, ny))
                visitedArray[nx][ny] = 1
            }
        }
    }
}