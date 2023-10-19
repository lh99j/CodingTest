import java.io.*
import java.lang.StringBuilder

private val mo = arrayOf("a", "e", "i", "o", "u")
private lateinit var arr: Array<String>
private lateinit var strs: List<String>
private var sb = StringBuilder()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (size, n) = readLine().split(" ").map{ it.toInt() }
    strs = readLine().split(" ").map { it.toString() }.sorted()

    arr = Array(size){ "" }

    makePass(0, 0, 0, 0)
    println(sb)
}

private fun makePass(depth: Int, start: Int, m: Int, j: Int){
    if(depth == arr.size){
        if(m >= 1 && j >= 2) {
            arr.forEach {
                sb.append(it)
            }
            sb.append("\n")
        }
        return
    }

    for(i in start until strs.size){
        arr[depth] = strs[i]

        if(mo.contains(strs[i])){
            makePass(depth + 1, i + 1, m + 1, j)
        }else{
            makePass(depth + 1, i + 1, m, j + 1)
        }

        arr[depth] = ""
    }
}