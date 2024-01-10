class PickOrange {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var countT = tangerine.distinct().map { t -> tangerine.count { t == it } }.sortedDescending()
        var sum = 0
        for(i in countT.indices){
            sum += countT[i]
            answer++
            if(sum >= k){
                break
            }
        }

        return answer
    }
}

fun main() {
    val po = PickOrange()
    println(po.solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
}