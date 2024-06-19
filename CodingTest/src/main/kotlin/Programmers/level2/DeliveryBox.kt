import java.util.*

class DeliveryBox {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val q: Queue<Int> = LinkedList()
        val s = Stack<Int>()

        for(i in 1..order.size){
            q.offer(i)
        }

        for(i in order.indices){
            var find = false

            //보조 컨테이너에서 찾은 경우
            if(s.isNotEmpty() && s.peek() == order[i]){
                s.pop()
                find = true
            }else{
                //찾을 때 까지 큐 다 빼버리기
                while(q.isNotEmpty()){
                    val value = q.poll()

                    if(value == order[i]){
                        find = true
                        break
                    }

                    s.push(value)
                }
            }

            if(!find){
                break
            }

            answer++
        }

        return answer
    }
}