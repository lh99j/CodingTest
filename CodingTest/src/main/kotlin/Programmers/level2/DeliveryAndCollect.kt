class DeliveryAndCollect {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0

        val reverseD = deliveries.reversed()
        val reverseP = pickups.reverse()
        var tempD = 0
        var tempP = 0

        for(i in 0 until n){
            tempD += reverseD[i]
            tempP += pickups[i]

            while(tempD > 0 || tempP > 0){
                tempD -= cap
                tempP -= cap
                answer += (n - i) * 2
            }
        }

        return answer
    }
}

fun main(args: Array<String>){

}