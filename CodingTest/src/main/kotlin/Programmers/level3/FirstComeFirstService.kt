class FirstComeFirstService {
    fun solution(n: Int, cores: IntArray): Int {
        var left = 0
        var s = n - cores.size
        var t = 0
        var right = 10000 * n
        var ans = 0

        if(n <= cores.size){
            return n
        }

        while (left < right) {
            val mid = (left + right) / 2

            t = 0
            cores.forEach {
                t += mid / it
            }

            if (t < s) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        cores.forEach {
            s -= (right - 1) / it
        }


        for ((idx, value) in cores.withIndex()) {
            if (right % value == 0) {
                s--
                if (s == 0) {
                    ans = idx + 1
                    break
                }
            }
        }
        return ans
    }
}

fun main() {
    val fcfs = FirstComeFirstService()
    println(fcfs.solution(6, intArrayOf(1, 2, 3)))
}