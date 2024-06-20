class QuadCompressionAndCount {
    private var size = 0
    private lateinit var map: Array<IntArray>
    fun solution(arr: Array<IntArray>): IntArray {
        map = arr
        size = arr.size

        if (size == 1) {
            val zeroCnt = map.sumOf { it.count { value -> value == 0 } }
            val oneCnt = map.sumOf { it.count { value -> value == 1 } }
            return intArrayOf(zeroCnt, oneCnt)
        }

        var max = getNum(size)
        for (p in max downTo 1) {
            val pow = 1 shl p
            for (i in 0 until size step (pow)) {
                for (j in 0 until size step (pow)) {
                    if (map[i][j] == -1) {
                        continue
                    }
                    if (check(i, j, pow)) {
                        mapping(i, j, pow)
                    }
                }
            }
        }

        val zeroCnt = map.sumOf { it.count { value -> value == 0 } }
        val oneCnt = map.sumOf { it.count { value -> value == 1 } }

        return intArrayOf(zeroCnt, oneCnt)
    }

    private fun check(x: Int, y: Int, pow: Int): Boolean {
        val standard = map[x][y]
        for (i in 0 until pow) {
            for (j in 0 until pow) {
                if (map[x + i][y + j] != standard) {
                    return false
                }
            }
        }

        return true
    }

    private fun mapping(x: Int, y: Int, pow: Int) {
        val value = map[x][y]
        for (i in 0 until pow) {
            for (j in 0 until pow) {
                map[x + i][y + j] = -1
            }
        }

        map[x][y] = value
    }

    private fun getNum(num: Int): Int {
        var m = 2
        var cnt = 1
        while (true) {
            if (m == num) {
                break
            }

            m *= 2
            cnt++
        }

        return cnt
    }

}