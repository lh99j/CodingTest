import java.util.*

class MoveBrideTruck {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var time = 1
        var sum = 0
        val q: Queue<Int> = LinkedList()
        val inputs = truck_weights.toMutableList()

        repeat(bridge_length){
            q.offer(0)
        }

        while(inputs.isNotEmpty() || q.isNotEmpty()){
            sum -= q.poll()

            if(inputs.isNotEmpty()){
                if(sum + inputs.first() <= weight){
                    q.offer(inputs.first())
                    sum += inputs.first()
                    inputs.removeFirst()
                }else{
                    q.offer(0)
                }
            }else{
                while(q.isNotEmpty()){
                    q.poll()
                    time++
                }
                break
            }

            time++
        }


        return time
    }
}

fun main(){
    val mbt = MoveBrideTruck()
    println(mbt.solution(100, 100, intArrayOf(10,10,10,10,10,10,10,10,10,10)))
}