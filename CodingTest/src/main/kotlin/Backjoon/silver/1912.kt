import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

// 당연하게 메모리초과,,, ㅎㅎ

//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val num = br.readLine().toInt()
//    var numArray = br.readLine().split(" ").map { it.toInt() }
//    var resultArray = mutableListOf<Int>()
//
//    for(i in 0 until numArray.size){
//        var temp = numArray[i]
//        resultArray.add(temp)
//        for(j in i + 1 until numArray.size){
//            temp += numArray[j]
//            resultArray.add(temp)
//        }
//    }
//
//    resultArray.sortDescending()
//    println(resultArray[0])
//}


fun main(args: Array<String>) {
    // numArr  :  10   -4   3     1    5    6   -35   12  21   -1
    // dpArray :  10    6   9    10   15   21   -14   12  33   32
    //   max   :  10   10   10   10   15   21    21   21  33   32

    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    var numArray = br.readLine().split(" ").map { it.toInt() }

    var dpArray = MutableList<Int>(size){ 0 }

    dpArray[0] = numArray[0]
    var max = dpArray[0]

    for(i in 1 until size){
         dpArray[i] = max(dpArray[i - 1] + numArray[i], numArray[i])
         max = max(dpArray[i], max)
    }

    println(max)
}

//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val num = br.readLine().toInt()
//    var numArray = br.readLine().split(" ").map { it.toInt() }
//
//    var dpArray = mutableListOf<Int>()
//
//    for(i in 0 until numArray.size){
//        for(j in i until numArray.size){
//            dpArray.add(dp(numArray[i], numArray[j]))
//        }
//    }
//
//    println(dpArray)
//
//}
//
//fun dp(i: Int, j: Int): Int{
//    if(i == j)
//        return publicArray[i]
//    else{
//        return dp(i, i) + dp(i + 1, j)
//    }
//}