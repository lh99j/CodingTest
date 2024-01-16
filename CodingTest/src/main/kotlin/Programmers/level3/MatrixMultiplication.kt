class MatrixMultiplication {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<MutableList<Int>> {
        var answer: Array<MutableList<Int>> = Array<MutableList<Int>>(arr1.size) { mutableListOf() }

        for (i in arr1.indices) {
            for(j in 0 until arr2[0].size){
                var sum = 0
                for(k in 0 until arr1[0].size){
                    sum += arr1[i][k] * arr2[k][j]
                }
                answer[i].add(sum)
            }
        }
        return answer
    }
}