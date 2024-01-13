class HIndex {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var cnt = citations.maxOrNull()

        for (i in 0..cnt!!) {
            var up = citations.count { it >= i }

            if(i <= up){
                answer = i
            }
        }


        return answer
    }
}

fun main(){
    val hi = HIndex()
    println(hi.solution(intArrayOf(25, 8, 5, 3, 3)))
}