import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

private var sb = StringBuilder()
private lateinit var nums: Array<Int>
private lateinit var visited: Array<Boolean>
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (size, pick) = br.readLine().split(" ").map { it.toInt() }
    nums = Array(pick){ 0 }
    visited = Array<Boolean>(size){ false }
    NAndM(size, pick, 0)

    println(sb)
    br.close()
}

private fun NAndM(n: Int, m: Int, depth: Int){
    if(m == depth){
        nums.forEach {
            sb.append(it).append(" ")
        }
        sb.append("\n")
        return
    }

    for(i in 0 until n){
        if(visited[i]){
            continue
        }
        visited[i] = true
        nums[depth] = i + 1
        NAndM(n, m, depth + 1)
        visited[i] = false
    }
}