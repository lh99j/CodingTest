import java.lang.Integer.max
import java.util.*

class Covid19Check {
    data class Dot(val x: Int, val y: Int)
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun solution(places: Array<Array<String>>): MutableList<Int> {
        var answer: MutableList<Int> = mutableListOf()

        for(i in places.indices){
            answer.add(separateArrayAndBfs(places[i]))
        }

        return answer
    }

    private fun separateArrayAndBfs(strArr: Array<String>): Int{
        var classRoom = Array(5){Array(5) { 'a' } }

        for(i in 0 until 5){
            var str = strArr[i]
            for(j in 0 until 5){
                classRoom[i][j] = str[j]
            }
        }

        for(i in 0 until 5){
            for(j in 0 until 5){
                if(classRoom[i][j] == 'P' && bfs(classRoom, i, j)) {
                    return 0
                }
            }
        }

        return 1
    }

    fun bfs(classRoom: Array<Array<Char>>, x: Int, y: Int): Boolean{
        var visited = Array(5){Array(5) { -1 } }
        var q: Queue<Dot> = LinkedList<Dot>()

        visited[x][y]= 0
        q.offer(Dot(x, y))

        while (q.isNotEmpty()){
            val temp = q.poll()

            for(i in 0 until 4){
                val nx = temp.x + dx[i]
                val ny = temp.y + dy[i]

                if(nx in 0 until 5 && ny in 0 until 5 && visited[nx][ny] == -1 && classRoom[nx][ny] != 'X'){
                    if(classRoom[nx][ny] == 'P' && (visited[temp.x][temp.y] + 1) <= 2){
                        return true
                    }
                    q.offer(Dot(nx, ny))
                    visited[nx][ny] = visited[temp.x][temp.y] + 1

                }
            }
        }

        return false
    }
}

fun main(args: Array<String>){
    val vc = Covid19Check()
}
