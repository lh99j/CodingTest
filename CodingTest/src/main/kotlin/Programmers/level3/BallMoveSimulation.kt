import java.lang.Math.abs

class BallMoveSimulation {
    fun solution(n: Int, m: Int, x: Int, y: Int, queries: Array<IntArray>): Long {
        var r1 = x
        var r2 = x
        var c1 = y
        var c2 = y

        // (r1, c1)
        // (r2, c2)

        for (i in queries.size - 1 downTo 0) {
            val d = queries[i][0]
            val cnt = queries[i][1]

            when (d) {
                0 -> { // 오른쪽으로 이동
                    c2 += cnt

                    //만약 벽에 붙어 있었던 상태가 아니었다면 이동 즉, c1 = 0(벽) 이면 범위는 0 ~ cnt
                    if (c1 != 0) c1 += cnt

                    // 만약 벽을 넘어간다면 재조정
                    if (c2 > m - 1) c2 = m - 1

                    // 범위를 벗어났으므로 불가능한 조건
                    if (c1 > m - 1) return 0
                }

                1 -> {//좌
                    c1 -= cnt

                    if (c2 != m - 1) c2 -= cnt
                    if (c1 < 0) c1 = 0
                    if (c2 < 0) return 0
                }

                2 -> {//하
                    r2 += cnt

                    if (r1 != 0) r1 += cnt
                    if (r2 > n - 1) r2 = n - 1
                    if (r1 > n - 1) return 0
                }

                else -> {//상
                    r1 -= cnt

                    if (r2 != n - 1) r2 -= cnt
                    if (r1 < 0) r1 = 0
                    if (r2 < 0) return 0
                }
            }
        }
        return abs(r2 - r1 + 1).toLong() * abs(c2 - c1 + 1).toLong()
    }
}