import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()

    println(tileRecursion(num))

}

fun tileRecursion(num: Int): Int{
    if(num == 1)
        return 1
    else if(num == 2)
        return 2
    else
        return tileRecursion(num - 2) + tileRecursion(num - 1)
}