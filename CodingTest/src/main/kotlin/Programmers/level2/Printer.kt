import java.util.LinkedList
import java.util.Queue

class Printer {
    private data class Dot(var x: Int, var y: Int)

    fun solution(priorities: IntArray, location: Int): Int {
        var q: Queue<Dot> = LinkedList<Dot>()
        var printArray = mutableListOf<Int>()
        var prioritiesQ: Queue<Int> = LinkedList<Int>()

        for (i in priorities.indices) {
            q.offer(Dot(i, priorities[i]))
        }

        var sortP = priorities.sortedDescending()
        for (i in sortP.indices) {
            prioritiesQ.offer(sortP[i])
        }

        while (q.isNotEmpty()) {
            var temp = q.poll()
            var x = temp.x
            var y = temp.y

            if (y == prioritiesQ.peek()) {
                printArray.add(x)
                prioritiesQ.poll()
            } else {
                q.offer(temp)
            }
        }

        return printArray.indexOf(location) + 1
    }
}

fun main(args: Array<String>) {
    val p = Printer()
    println(p.solution(intArrayOf(2, 1, 3, 2), 2))
}