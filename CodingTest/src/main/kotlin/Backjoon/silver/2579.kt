import java.io.*
import kotlin.math.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    var valueArray = MutableList<Int>(1) { 0 }
    var dpArray = MutableList<Int>(num + 1) { 0 }


    repeat(num) {
        valueArray.add(br.readLine().toInt())
    }


    for(i in 1..num){
        when(i){
            0 -> dpArray[0] = valueArray[0]
            1 -> dpArray[1] = valueArray[1]
            2 -> dpArray[2] = valueArray[1] + valueArray[2]
            3 -> dpArray[3] = max(valueArray[1] + valueArray[3], valueArray[2] + valueArray[3])
            else -> {
                dpArray[i] = max(dpArray[i - 2] + valueArray[i], dpArray[i - 3] + valueArray[i - 1] + valueArray[i])
            }
        }
    }

    println(dpArray[num])
}