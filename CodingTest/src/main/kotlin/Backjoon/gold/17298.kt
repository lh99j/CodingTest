import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine()
    val nums = br.readLine().split(" ").map { it.toInt() }

    val rvNums = nums.reversed()
    var s = Stack<Int>()
    var ans = mutableListOf<Int>()

    ans.add(-1)
    s.push(rvNums[0])

    for (i in 1 until rvNums.size) {
        while(true){
            if(s.empty()){
                s.push(rvNums[i])
                ans.add(-1)
                break
            }else{
                val p = s.peek()
                if(p <= rvNums[i]){
                    s.pop()
                }else{
                    ans.add(p)
                    s.push(rvNums[i])
                    break
                }
            }
        }
    }

    println(ans.reversed().joinToString(" "))
}