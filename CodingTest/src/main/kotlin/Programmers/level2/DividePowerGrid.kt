import java.util.*
import java.lang.Math.min
import java.lang.Math.pow

class DividePowerGrid {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = -1
        val powerGrid = Array<MutableList<Int>>(n + 1) { mutableListOf() }

        wires.forEach {
            powerGrid[it[0]].add(it[1])
            powerGrid[it[1]].add(it[0])
        }

        powerGrid.forEach {
            it.sort()
        }

        var minValue = 101
        wires.forEach {
            minValue = min(bfs(powerGrid, it[0], it[1]), minValue)
            answer = minValue

        }

        return answer
    }

    private fun bfs(pwGrid: Array<MutableList<Int>>, x: Int, y: Int): Int {
        val visited = MutableList(pwGrid.size) { 0 }

        val firstQ: Queue<Int> = LinkedList<Int>()
        val secondQ: Queue<Int> = LinkedList<Int>()
        var firstValue = 0
        var secondValue = 0

        pwGrid[x].remove(y)
        pwGrid[y].remove(x)
        visited[x] = ++firstValue
        visited[y] = ++secondValue

        firstQ.offer(x)
        secondQ.offer(y)

        while (firstQ.isNotEmpty()) {
            val element = firstQ.poll()

            pwGrid[element].forEach {
                if (visited[it] == 0) {
                    firstQ.offer(it)
                    visited[it] = ++firstValue
                }
            }
        }

        while (secondQ.isNotEmpty()) {
            val element = secondQ.poll()

            pwGrid[element].forEach {
                if (visited[it] == 0) {
                    secondQ.offer(it)
                    visited[it] = ++secondValue
                }
            }
        }

        pwGrid[x].add(y)
        pwGrid[y].add(x)

        return Math.abs(firstValue - secondValue)
    }
}

fun main(args: Array<String>) {
    val dpg = DividePowerGrid()
    println(
        dpg.solution(
            9,
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(4, 6),
                intArrayOf(4, 7),
                intArrayOf(7, 8),
                intArrayOf(7, 9)
            )
        )
    )
}