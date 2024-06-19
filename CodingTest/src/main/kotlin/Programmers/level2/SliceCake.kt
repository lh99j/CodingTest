import java.util.*

class SliceCake {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val left = mutableMapOf<Int, Int>()
        val right = mutableMapOf<Int, Int>()

        topping.forEach{
            right[it] = right.getOrDefault(it, 0) + 1
        }

        topping.forEach{
            left[it] = left.getOrDefault(it, 0) + 1
            right[it] = right[it]!! - 1

            if(right[it]!! == 0){
                right.remove(it)
            }

            if(left.size == right.size){
                answer++
            }
        }

        return answer
    }
}