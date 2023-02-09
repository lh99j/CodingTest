import java.io.BufferedReader
import java.io.InputStreamReader

//초기버전(시간초과)
var array = MutableList<Int>(1000001) { -1 }

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()

    println(tileRecursion(num) % 15746)
}

fun tileRecursion(num: Int): Int {
    if (array[num] != -1)
        return array[num]

    if (num == 1)
        return 1
    else if (num == 2)
        return 2
    else {
//        return tileRecursion(num - 2) + tileRecursion(num - 1)
        array[num] = (tileRecursion(num - 2) + tileRecursion(num - 1)) % 15746
        return array[num]
    }
}

//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val num = br.readLine().toInt()
//    var tileArray = mutableListOf<Int>()
//
//    tileArray.add(1)
//    tileArray.add(2)
//
//    for (i in 2..num) {
//        val tempNum = tileArray[i - 2] + tileArray[i - 1]
//        tileArray.add(tempNum % 15746)
//    }
//
//    println(tileArray[num - 1])
//}