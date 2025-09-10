import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val orders = mutableListOf<String>()
    var c = n - 1
    var ans = ""

    repeat(n) {
        orders.add(br.readLine())
    }

    while(c >= 0) {
        val (type, value, time) = orders[c].split(" ")

        if(type == "type"){
            ans += value
        } else {
            for(i in 1..value.toInt()) {
                if(c - 1 >= 0) {
                    val next = orders[c - 1].split(" ")
                    val nTime = next[2].toInt()

                    if(nTime >= time.toInt() - value.toInt()) {
                        c--
                    } else {
                        break
                    }
                }else {
                    break
                }
            }
        }

        c--
    }

    println(ans.reversed())
}