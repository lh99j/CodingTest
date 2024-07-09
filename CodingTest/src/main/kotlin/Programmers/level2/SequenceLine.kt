class SequenceLine {
    fun solution(np: Int, kp: Long): List<Int> {
        val nums = MutableList(np) { it + 1 }
        val ans = mutableListOf<Int>()

        var t = np - 1
        var n = fac(np - 1)
        var k = kp

        while (t >= 0) {
            val index = n / k
            val number = nums[index.toInt()]
            ans.add(number)
            nums.removeAt(nums.indexOf(number))

            if (k > 0) {
                k %= n
                n /= t
            }

            t--
        }


        ans.addAll(nums)
        return ans
    }

    private fun fac(n: Int): Long {
        var out: Long = 1

        for (i in 1 until n) {
            out *= i
        }

        return out
    }

}

fun main() {
    val sl = SequenceLine()
    println(sl.solution(5, 18))
}