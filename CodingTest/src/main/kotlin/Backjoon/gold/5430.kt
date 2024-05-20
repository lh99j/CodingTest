import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T){
        val func = br.readLine().chunked(1)
        val size = br.readLine().toInt()
        var nums = br.readLine().removeSurrounding("[", "]").split(",").toMutableList()

        val cnt = func.count { it == "D" }
        if(cnt > size){
            sb.append("error").append("\n")
        }else if (cnt == size){
            sb.append("[]").append("\n")
        }else{
            var first = 0
            var end = size - 1

            //true 면 앞, false 면 뒤
            var s = true

            func.forEach {
                when (it) {
                    "D" -> {
                        if(s){
                            first++
                        }else{
                            end--
                        }
                    }
                    "R" -> {
                        s = !s
                    }
                }
            }

            var nums = nums.slice(first..end).toMutableList()
            if(!s){
                nums.reverse()
            }

            sb.append("[${nums.joinToString(",")}]").append("\n")
        }
    }

    println(sb)
}