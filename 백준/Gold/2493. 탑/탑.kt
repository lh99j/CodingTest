import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    val s = Stack<Int>()

    s.push(0)
    sb.append(0).append(" ")
    
    for(i in 1 until n){
        while(s.isNotEmpty() && inputs[s.peek()] < inputs[i]){
            s.pop()
        }

        if(s.isNotEmpty()){
            sb.append(s.peek() + 1).append(" ")
        }else{
            sb.append(0).append(" ")
        }

        s.push(i)
    }

    println(sb)
}