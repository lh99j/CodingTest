import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    var pq = PriorityQueue<Int>()
    var ans = 0

    repeat(br.readLine().toInt()) {
        pq.offer(br.readLine().toInt())
    }

    if(pq.size > 1){
        while(true) {
            val first = pq.poll()
            val second = pq.poll()
            val sum = first + second

            ans += sum
            if(pq.isEmpty()){
                break
            }
            pq.offer(sum)
        }
        println(ans)
    }else{
        println(0)
    }

}