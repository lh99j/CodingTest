class SumOfSequences {
    fun solution(sequence: IntArray): Long {
        var pDp = Array<Long>(sequence.size){ 0 }
        var mDp = Array<Long>(sequence.size){ 0 }
        var op = 1

        sequence.forEachIndexed { idx, value ->
            if(idx == 0){
                pDp[0] = value.toLong()
                mDp[0] = -value.toLong()
            }else{
                pDp[idx] = maxOf(pDp[idx - 1] + value * op, value.toLong() * op)
                mDp[idx] = maxOf(mDp[idx - 1] - value * op,  -value.toLong() * op)
            }

            op = -op
        }

        return maxOf(pDp.maxOrNull()!!, mDp.maxOrNull()!!)
    }
}