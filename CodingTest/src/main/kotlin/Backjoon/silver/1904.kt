import java.io.BufferedReader
import java.io.InputStreamReader

//초기버전(시간초과)

//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val num = br.readLine().toInt()
//
//    println(tileRecursion(num) % 15746)
//
//}
//
//fun tileRecursion(num: Int): Int{
//    if(num == 1)
//        return 1
//    else if(num == 2)
//        return 2
//    else
//        return tileRecursion(num - 2) + tileRecursion(num - 1)
//}


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    var array = mutableListOf<Int>()

    array.add(1)
    array.add(2)

    for(i in 2..num){
        val tempNum = array[i - 2] + array[i - 1]
        array.add(tempNum % 15746)
    }

    println(array[num - 1])
}