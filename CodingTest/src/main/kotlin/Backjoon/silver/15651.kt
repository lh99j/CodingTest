import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

private var sb = StringBuilder()
private lateinit var visited: Array<Boolean>
private lateinit var arr: Array<Int>

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    visited = Array(N){ false }
    arr = Array(M){ 0 }

    NAndM(N, M, 0)
    println(sb)

    br.close()
}

private fun NAndM(N: Int, M: Int, depth: Int){
    if(depth == M){
        arr.forEach {
            sb.append(it).append(" ")
        }
        sb.append("\n")

        return
    }

    for(i in 0 until N){
        visited[i] = true
        arr[depth] = i + 1
        NAndM(N, M, depth + 1)
        visited[i] = false
    }
}