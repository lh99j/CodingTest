import java.util.*

class OpenChatting {
    fun solution(record: Array<String>): MutableList<String> {
        val id = mutableMapOf<String, String>()
        val order = mutableListOf<Pair<String, String>>()
        var answer = mutableListOf<String>()

        record.forEach{
            val inputs = it.split(" ")


            if(inputs[0] == "Enter"){
                id[inputs[1]] = inputs[2]
                order.add(inputs[0] to inputs[1])
            }else if(inputs[0] == "Leave"){
                order.add(inputs[0] to inputs[1])
            }else{
                id[inputs[1]] = inputs[2]
            }
        }


        order.forEach{
            if(it.first == "Enter"){
                answer.add("${id[it.second]!!}님이 들어왔습니다.")
            }else{
                answer.add("${id[it.second]!!}님이 나갔습니다.")
            }
        }

        return answer
    }
}