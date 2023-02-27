import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

// [시간 초과]
//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    var (a, b) = br.readLine().split(" ").map { it.toInt() }
//    var dpArray = br.readLine().split(" ").map { it.toInt() }
//    var sb = StringBuilder()
//
//    for (i in 0 until b) {
//        var (start, end) = br.readLine().split(" ").map { it.toInt() }
//        var sum = 0
//
//        for (i in start - 1..end - 1) {
//            sum += dpArray[i]
//        }
//
//        sb.append("$sum\n")
//
//    }
//
//    println(sb)
//
//}

fun main(arg: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (a, b) = br.readLine().split(" ").map { it.toInt() }
    var numArray = br.readLine().split(" ").map { it.toInt() }
    var dpArray = MutableList<Int>(a){ 0 }
    var sum = 0

    for(i in numArray.indices){
        sum += numArray[i]
        dpArray[i] = sum
    }

    var sb = StringBuilder()

    for (i in 0 until b) {
        var (start, end) = br.readLine().split(" ").map { it.toInt() }
        var temp = 0
        if(start == 1){
            temp = dpArray[end - 1]
        }else{
            temp = dpArray[end - 1] - dpArray[start - 2]
        }

        sb.append("$temp\n")
    }

    println(sb)
}
