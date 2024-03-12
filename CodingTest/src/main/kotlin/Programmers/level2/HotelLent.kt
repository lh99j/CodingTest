import java.util.*

class HotelLent {
    fun solution(book_time: Array<Array<String>>): Int {
        var ans: Int = 0
        val input = mutableListOf<Pair<Int, Int>>()
        val pq = PriorityQueue<Int>()

        book_time.forEach{ (first, end) ->
            val f = first.split(":").map{ it.toInt() }
            val e = end.split(":").map{ it.toInt() }

            input.add(f[0] * 60 + f[1] to e[0] * 60 + e[1] + 10)
        }

        input.sortedWith(compareBy({it.first}, {it.second})).forEach{ (first, end) ->
            if(pq.isEmpty()){
                pq.offer(end)
            }else{
                if(pq.peek() <= first){
                    pq.poll()
                }

                pq.offer(end)
            }
        }

        return pq.size
    }
}