import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (size, count) = br.readLine().split(" ").map { it.toInt() }
    var array = Array(size) { ArrayList<Int>(size) }
    var sumArray = Array(size + 1){ IntArray(size + 1){ 0 } }
    var sb = StringBuilder()

    repeat(size) { index ->
        val elements = br.readLine().split(" ").map { it.toInt() }
        array[index].addAll(elements)
    }

    for(i in 1 until array.size + 1){
        for(j in 1 until array[0].size + 1){
            sumArray[i][j] = sumArray[i - 1][j] + sumArray[i][j - 1] - sumArray[i - 1][j - 1] + array[i - 1][j  -1]
        }
    }

    for(i in 0 until count){
        var (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        var temp = sumArray[x2][y2] - sumArray[x2][y1 -1] - sumArray[x1 -1][y2] + sumArray[x1 -1][y1 - 1]
        sb.append(temp).append("\n")
    }

    //2차원 배열 출력
//    sumArray.forEach {
//        it.forEach {
//            print("$it ")
//        }
//        println()
//    }

    println(sb)
}