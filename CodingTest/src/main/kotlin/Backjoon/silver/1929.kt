import java.io.*
import java.util.*
import java.math.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var temp= br.readLine().split(" ")
    var a = temp[0].toInt()
    var b = temp[1].toInt()

    var array = BooleanArray(b + 1)
    var sb = StringBuilder()

    for(i in 2..b){

        if(array[i])
            continue

        for(j in i * 2 .. b step(i))
            array[j] = true
    }

    array[1] = true

    for(i in a..b){
        if(!array[i])
            sb.append(i).append("\n")
    }

    println(sb)
}