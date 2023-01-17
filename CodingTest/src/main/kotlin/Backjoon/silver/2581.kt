import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var a = br.readLine().toInt()
    var b = br.readLine().toInt()
    var answer = 0

    var numList: MutableList<Int> = mutableListOf()

    for(i in 0..b){
        numList.add(i)
    }

    numList[1] = 0

    for(i in 2 until numList.size){
        if(numList[i] == 0)
            continue
        for(j in i * 2 until numList.size step i){
            numList[j] = 0
        }
    }

    var list: MutableList<Int> = mutableListOf()

    numList.forEach {
        if(it in a..b){
            list.add(it)
        }
    }


    if(list.size != 0){
        println(list.sum())
        println(list.min())
    }else{
        println(-1)
    }



}