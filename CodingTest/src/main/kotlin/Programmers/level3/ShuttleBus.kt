import java.util.*

class ShuttleBus {
    fun solution(n: Int, t: Int, m: Int, timetable: Array<String>): String {
        var times = mutableListOf<Pair<Int, Int>>()
        var hour = 9
        var minute = 0
        var ansh = 0
        var ansm = 0


        timetable.forEach { time ->
            val splitTime = time.split(":").map { it.toInt() }
            times.add(splitTime[0] to splitTime[1])
        }

        times.sortWith(compareBy({ it.first }, { it.second }))

        var lastTime = 0 to 0
        var cnt = 0

        for (i in 0 until n) {
            cnt = 0
            while (times.isNotEmpty() && compareTime(hour to minute, times[0]) && cnt < m) {
                lastTime = times.removeFirst()
                cnt++
            }


            if (i != n - 1) {
                minute += t
                if (minute >= 60) {
                    hour++
                    minute -= 60
                }
            }
        }

        if (cnt < m) {
            ansh = hour
            ansm = minute
        } else {
            ansh = lastTime.first
            ansm = lastTime.second - 1

            if (ansm < 0) {
                ansm += 60
                ansh--
            }
        }


        return String.format("%02d:%02d", ansh, ansm)
    }

    private fun compareTime(first: Pair<Int, Int>, second: Pair<Int, Int>): Boolean {
        if (first.first > second.first) {
            return true
        } else if (first.first == second.first && first.second >= second.second) {
            return true
        }
        return false
    }
}

fun main() {
    val sb = ShuttleBus()
    println(sb.solution(1, 1, 1, arrayOf("23:59")))
}