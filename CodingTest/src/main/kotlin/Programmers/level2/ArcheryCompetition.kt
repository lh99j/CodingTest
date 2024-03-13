class ArcheryCompetition {
    private var scores = Array<Int>(11){ 0 }
    private var ans = Array<Int>(11){ 0 }
    private var gap = 0

    fun solution(n: Int, info: IntArray): Array<Int> {
        back(0, n, info)

        return if(gap == 0){
            arrayOf(-1)
        }else{
            ans
        }
    }

    private fun back(depth: Int, n: Int, info: IntArray){
        if(depth == n){
            var aS = 0
            var rS = 0

            for(i in 0..10){
                if(scores[i] > info[i]){
                    rS += 10 - i
                }else if(info[i] > 0 && info[i] >= scores[i]){
                    aS += 10 - i
                }
            }

            var tGap = rS - aS

            if(tGap >= gap){
                gap = tGap
                ans = scores.clone()
            }

            return
        }

        for(i in 0..10){
            if(n - depth >= info[i] + 1 && scores[i] <= info[i]){
                scores[i] += info[i] + 1
                back(depth + info[i] + 1, n, info)
                scores[i] -= info[i] + 1
            }

            if(i == 10){
                scores[i] += n - depth
                back(depth + n - depth, n, info)
                scores[i] -= n - depth
            }
        }
    }
}