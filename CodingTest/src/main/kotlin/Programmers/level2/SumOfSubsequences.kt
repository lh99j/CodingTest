class SumOfSubsequences {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val range = sequence.indices
        var start = 0
        var end = 0
        var sum = sequence[0]
        var ans = intArrayOf()

        while(start <= end && start in range && end in range){
            if(sum == k){
                if(ans.isEmpty()){
                    ans = intArrayOf(start, end)
                    continue
                }else{
                    val s = ans[0]
                    val e = ans[1]
                    val l = e - s
                    val cs = end - start

                    if(cs < l){
                        ans = intArrayOf(start, end)
                        continue
                    }

                    if(cs == l && s > start){
                        ans = intArrayOf(start, end)
                        continue
                    }
                }
            }

            if(sum <= k){
                end++
                if(end !in range){
                    break
                }
                sum += sequence[end]
            }

            if(sum > k){
                sum -= sequence[start]
                start++
            }
        }



        return ans
    }
}