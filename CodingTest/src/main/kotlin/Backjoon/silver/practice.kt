import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    var arr = mutableListOf<Int>()

    repeat(cnt){
        arr.add(br.readLine().toInt())
    }

    arr.sortDescending()

    for(i in arr.indices){
        println(arr[i])
    }
}