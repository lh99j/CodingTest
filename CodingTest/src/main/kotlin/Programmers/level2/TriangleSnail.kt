class TriangleSnail {
    private lateinit var ans: Array<IntArray>
    private val dx = intArrayOf(1, 0, -1)
    private val dy = intArrayOf(0, 1, -1)
    private var N = 0

    fun solution(n: Int): MutableList<Int> {
        N = n
        ans = Array(n) { IntArray(n) { 0 } }

        var x = 0
        var y = 0
        var d = 0
        var value = 1

        while (true) {
            if (!validPosition(x, y) || ans[x][y] != 0) {
                break
            }

            ans[x][y] = value

            val nx = x + dx[d]
            val ny = y + dy[d]

            if (validPosition(nx, ny) && ans[nx][ny] == 0) {
                x = nx
                y = ny
            } else {
                d = (d + 1) % 3

                x += dx[d]
                y += dy[d]
            }

            value++
        }

        val out = mutableListOf<Int>()

        ans.forEach {
            it.forEach { num ->
                if (num != 0) {
                    out.add(num)
                }
            }
        }
        return out
    }

    private fun validPosition(x: Int, y: Int) = x in 0 until N && y in 0 until N
}