import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var arr: Array<Int>
private var sum = 0
private var w = 0
private var ans = 0
private lateinit var nums: List<Int>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (size, p) = readLine().split(" ").map { it.toInt() }
    nums = readLine().split(" ").map { it.toInt() }
    w = p

    for(i in 1..size){
        arr = Array(i){ 0 }

        getCount(0, i, 0)
    }

    println(ans)
}

private fun getCount(cnt: Int, end: Int, start: Int){
    if(cnt == end){
        arr.forEach {
            sum += it
        }

        if(sum == w){
            ans++
        }

        sum = 0

        return
    }

    for(i in start until nums.size){
        arr[cnt] = nums[i]
        getCount(cnt + 1, end, i + 1)
        arr[cnt] = 0
    }
}