import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.IndexOutOfBoundsException
import kotlin.math.max

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var nums = Array<MutableList<String>>(5){ mutableListOf() }
    var str = ""
    var maxSize = 0

    for(i in 0 until 5){
        var str = br.readLine().toString()
        maxSize = max(maxSize, str.length)

        for(j in str.indices){
            nums[i].add(str[j].toString())
        }

    }

    for(i in 0 until maxSize){
        for(j in 0 until 5){
            if(nums[j].getOrNull(i) != null){
                str += nums[j][i]
            }
        }
    }

    println(str)
}