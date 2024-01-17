class Fatigue {
    private var visited = HashSet<Int>()

    private var ans = Int.MIN_VALUE
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        back(dungeons, k)

        return ans
    }

    private fun back(dungeons: Array<IntArray>, cur: Int) {
        ans = maxOf(ans, visited.size)

        for (i in dungeons.indices) {
            var temp = dungeons[i]
            if (i !in visited && cur >= temp[0]) {
                visited.add(i)
                back(dungeons, cur - temp[1])
                visited.remove(i)
            }
        }
    }
}

fun main() {
    val f = Fatigue()
    println(f.solution(80, arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))))
}