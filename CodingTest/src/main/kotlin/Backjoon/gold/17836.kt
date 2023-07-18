import java.util.*
import java.io.*
import java.lang.Math.min
import kotlin.collections.HashSet

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
//private data class Dot(var x: Int, var y: Int)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, m, t) = br.readLine().split(" ").map { it.toInt() }

    var mazeMap = Array<MutableList<Int>>(n) { mutableListOf() }

    for (i in 0 until n) {
        val numArr = br.readLine().split(" ").map { it.toInt() }
        mazeMap[i].addAll(numArr)
    }

    var answer = bfs(mazeMap, t)

    if (answer == -1) {
        println("Fail")
    } else {
        println(answer)
    }

}

private fun bfs(maze: Array<MutableList<Int>>, time: Int): Int {
    val q: Queue<Dot> = LinkedList()
    val visited = HashSet<Dot>()
    var swordX = -1
    var swordY = -1
    var swordDistance = 0
    var count = 1
    var swordTemp = 0

    visited.add(Dot(0, 0))
    q.offer(Dot(0, 0))
    var distance = 0

    while (q.isNotEmpty()) {
        val size = q.size

        for (i in 0 until size) {
            val temp = q.poll()

            for (i in 0 until 4) {
                val nx = dx[i] + temp.x
                val ny = dy[i] + temp.y


                if (nx in maze.indices && ny in 0 until maze[0].size && maze[nx][ny] != 1 && Dot(nx, ny) !in visited) {
                    if (maze[nx][ny] == 2) {
                        swordX = nx
                        swordY = ny
                        swordDistance = distance
                    }

                    swordTemp = (nx - swordX) + (ny - swordY)

                    if (nx == maze.size - 1 && ny == maze[0].size - 1) {
                        println("nx : $nx ny: $ny")
                        println("sword X Y : $swordX $swordY")
                        println("count : $count")
                        println("swrod Distance : $swordDistance")

                        if (swordX != -1 && swordY != -1 && count <= time) {


                            println("answer : $temp $distance")

                            return min(swordTemp + swordDistance + 1, distance + 1)
                        } else if (count <= time && swordX == -1 && swordY == -1) {
                            println("answer : $distance")

                            return distance + 1
                        }

                    }

                    q.offer(Dot(nx, ny))
                    visited.add(Dot(nx, ny))
                }

            }
        }

        distance++
        count++
    }

    swordTemp = ((maze.size - 1) - swordX) + ((maze[0].size - 1) - swordY)
    var answer = swordTemp + swordDistance + 1

    if(swordX != -1 && swordY != -1 && answer <= time){
        println("answer : $answer")
        println("swordTemp : $swordTemp")
        println("swordDistance $swordDistance")
        println("swordX : $swordX swordY : $swordY")
        println("map.size : ${maze.size - 1} maze[0].size : ${maze[0].size - 1}")
        return answer
    }

    return -1
}