import java.util.*

class MakeBigNumber {
    fun solution(number: String, k: Int): String {
        var answer = ""
        val q: Deque<Int> = LinkedList()

        var cnt = 0
        var idx = 0

        while(cnt != k && idx < number.length){
            val cur = number[idx].digitToInt()
            idx++

            if(q.isEmpty()){
                q.offerLast(cur)
            }else{
                while(q.isNotEmpty() && cnt != k && q.peekLast() < cur){
                    val value = q.pollLast()
                    cnt++
                }

                q.offerLast(cur)
            }
        }

        if(cnt == k) {
            var remain = number.substring(idx, number.length)
            while (q.isNotEmpty()) {
                answer += q.pollFirst().toString()
            }

            answer += remain
        }else{
            var t = 0
            while(t != number.length - k){
                answer += q.pollFirst().toString()
                t++
            }
        }

        return answer
    }

}

fun main(){
    val mb = MakeBigNumber()
    println(mb.solution("9873654321", 3))
}