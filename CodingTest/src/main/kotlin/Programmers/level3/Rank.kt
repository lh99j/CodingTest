class Rank {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val floyd = Array(n){ BooleanArray(n) { false } }

        results.forEach{ game ->
            val win = game[0] - 1
            val lose = game[1] - 1

            floyd[win][lose] = true
        }

        for(k in 0 until n){
            for(i in 0 until n){
                for(j in 0 until n){
                    if(floyd[i][k] && floyd[k][j]){
                        floyd[i][j] = true
                    }
                }
            }
        }

        for(i in 0 until n){
            var cnt = 0
            for(j in 0 until n){
                if(i == j){
                    continue
                }

                if(floyd[i][j] || floyd[j][i]){
                    cnt++
                }
            }

            if(cnt == n - 1){
                answer++
            }
        }


        return answer
    }
}