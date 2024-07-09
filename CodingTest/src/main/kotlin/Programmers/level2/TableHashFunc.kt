class TableHashFunc {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0

        data.sortWith(compareBy<IntArray> { it[col - 1] }.thenByDescending { it[0] })

        for (i in row_begin..row_end) {
            val sum = getSum(data[i - 1], i)
            answer = sum xor answer
        }
        return answer
    }

    private fun getSum(data: IntArray, i: Int): Int {
        var out = 0

        data.forEach {
            out += it % i
        }

        return out
    }
}