import java.io.*
import java.lang.StringBuilder

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var num = br.readLine().toInt()

    for(i in 0 until num){
        var a = br.readLine().toInt()
        var b = br.readLine().toInt()

        a++

        println(fibo(a, b))
    }

}

fun fibo(a: Int, b: Int): Int{
    return if(b == 1)
        1
    else if(a == 1)
        b
    else
        fibo(a, b - 1) + fibo(a - 1, b)
}