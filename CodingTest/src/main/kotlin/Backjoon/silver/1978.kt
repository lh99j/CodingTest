import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    val numList = br.readLine().split(" ").map { it.toInt() }
    var answer = 0

//    var decimalList: MutableList<Int> = MutableList<Int>(100) { it -> it * 1 }
    var decimalList: MutableList<Int> = mutableListOf()

    for(i in 0..1000){
        decimalList.add(i)
    }

    for (i in 2 until decimalList.size) {
        if (decimalList[i] == 0)
            continue
        for (j in 2 * i until decimalList.size step(i)) {
            decimalList[j] = 0
        }
    }

    decimalList[0] = 0
    decimalList[1] = 0

    var list = decimalList.distinct()

    numList.forEach {
        if(list.contains(it))
            answer++
    }

//    println(list)
    println(answer)
}