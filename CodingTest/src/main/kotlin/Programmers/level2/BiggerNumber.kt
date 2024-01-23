import java.util.*

class BiggerNumber {
    fun solution(numbers: IntArray): List<Int> {
        var ans = mutableListOf<Int>()

        var q = Stack<Int>()
        var nums = numbers.reversed()

        ans.add(-1)
        q.push(nums[0])

        for (i in 1 until nums.size) {
            while (true) {
                if (q.isEmpty()) {
                    q.push(nums[i])
                    ans.add(-1)
                    break
                } else {
                    if (q.peek() <= nums[i]) {
                        q.pop()
                    } else {
                        ans.add(q.peek())
                        q.push(nums[i])
                        break
                    }
                }
            }
        }

        return ans.reversed()
    }
}

//2 6 3 5 1 9
fun main(){
    val bn = BiggerNumber()
    println(bn.solution(intArrayOf(9, 1, 5, 3, 6, 2)))
}