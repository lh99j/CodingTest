class MakeMinNum {
    fun solution(A: IntArray, B: IntArray): Int {
        var answer = 0
        A.sort()
        B.sort()

        for (i in A.indices) {
            answer += A[i] * B[B.size - i - 1]
        }

        return answer
    }
}