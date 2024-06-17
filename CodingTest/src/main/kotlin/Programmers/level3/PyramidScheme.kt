class PyramidScheme {
    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var answer: IntArray

    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        answer = IntArray(enroll.size) { 0 }
        graph = Array(enroll.size) { mutableListOf() }
        referral.forEachIndexed{ index, name ->
            if(name != "-"){
                val idx = enroll.indexOf(name) //enroll
                graph[index].add(idx)
            }
        }

        seller.forEachIndexed{ index, name ->
            val enrollIdx = enroll.indexOf(name)
            dfs(enrollIdx, amount[index] * 100)
        }

        return answer
    }


    private fun dfs(current: Int, value: Int){
        val distribution = value / 10
        val currentAmount = value - distribution

        answer[current] += currentAmount

        if(distribution > 0 && graph[current].isNotEmpty()){
            dfs(graph[current][0], distribution)
        }
    }
}