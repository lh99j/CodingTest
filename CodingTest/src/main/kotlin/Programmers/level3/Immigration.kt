class Immigration {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var minTime: Long = 1
        var maxTime: Long = times.maxOrNull()!!.toLong() * n

        while(minTime <= maxTime){
            var avgTime: Long = (minTime + maxTime) / 2
            var sum: Long = 0

            times.forEach {
                sum += avgTime / it
            }

            if(sum >= n){
                maxTime = avgTime - 1
                answer = avgTime
            }else{
                minTime = avgTime + 1
            }
        }

        return answer
    }
}

fun main() {
    val i = Immigration()
}