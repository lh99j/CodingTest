import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = nums.size - 1
    var min = Int.MAX_VALUE
    var cLeft = 0
    var cRight = 0

    while(left < right){
        var compare = nums[left] + nums[right]

        if(min > abs(compare)){
            min = abs(compare)
            cLeft = nums[left]
            cRight = nums[right]
        }

        if(compare == 0){
            break
        }

        if(compare < 0) left++ else right--
    }

    println("$cLeft $cRight")
}