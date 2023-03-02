import java.util.LinkedList
import java.util.Queue

class FunctionDevelop {
    fun solution(progresses: IntArray, speeds: IntArray): MutableList<Int> {
        var answer = mutableListOf<Int>()
        var q: Queue<Int> = LinkedList<Int>()

        for (i in progresses.indices) {
            q.offer(progresses[i])
        }

        var before = 0
        var j = 1
        var i = 0

        var poll = q.poll()

        for (element in 1..100) {
            var temp = speeds[i] * element

            if (temp + poll >= 100) {
                before = element
                break
            }
        }

        i++

        while (q.isNotEmpty()) {
            var progress = q.poll()
            var days = 1

            for (element in 1..100) {
                var temp = speeds[i] * element

                if (temp + progress >= 100) {
                    days = element
                    break
                }
            }

            if (before >= days) {
                j++
            } else {
                answer.add(j)
                j = 1
                before = days
            }
            i++
        }

        answer.add(j)

        return answer
    }
}

fun main(args: Array<String>) {
    var fd = FunctionDevelop()
    println(fd.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)))

}