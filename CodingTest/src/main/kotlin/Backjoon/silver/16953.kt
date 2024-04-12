import java.io.BufferedReader
import java.io.InputStreamReader

private var ans = Long.MAX_VALUE
private var s: Long = 0
private var d: Long = 0

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ts, td) = br.readLine().split(" ").map { it.toLong() }
    s = ts
    d = td

    getValue(s, 1)

    if(ans == Long.MAX_VALUE){
        println(-1)
    }else{
        println(ans)
    }
}

private fun getValue(num: Long, cnt: Long){
    if(num > d){
        return
    }

    if(num == d){
        ans = minOf(ans, cnt)
    }

    getValue(num * 2, cnt + 1)
    getValue(num * 10 + 1, cnt + 1)
}