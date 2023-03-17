import java.io.*
import java.lang.*
import java.util.*
import kotlin.collections.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var array = Array<MutableList<Char>>(5) { mutableListOf() }
    var str = ""

    repeat(5) {
        var str = br.readLine().toString()

        for (i in 0 until str.length) {
            array[it].add(str[i])
        }
    }

    array.forEach {
        for(i in 0 until it.size){
            print("${it[i]} ")
        }
        println()
    }

    println(array[1][5])

//    for (i in 0 until array.size) {
//        for (j in 0 until array[0].size) {
//            if (array[i][j] == null) {
//                print("")
//            } else
//                print("${array[i][j]}")
//        }
//        println()
//    }

//    for(i in 0 until array[0].size){
//        for(j in 0 until array.size){
//            str += array[j][i]
//        }
//    }

    println(str)
}