import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, w) = br.readLine().split(" ").map { it.toInt() }
    val blocks = br.readLine().split(" ").map { it.toInt() }
    var ans = 0

    for(i in 1 until blocks.size - 1){
        //왼쪽 블록들의 최대값
        val leftMax = blocks.subList(0, i).max()
        //오른쪽 블록들의 최대값
        val rightMax = blocks.subList(i + 1, blocks.size).max()

        ans += maxOf(0 ,  minOf(leftMax, rightMax) - blocks[i])
    }

    println(ans)
}