import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    var ans = ""
    val n = br.readLine().toInt()
    var d = 1
    var end = 2
    
    if(end < n) {
        while(true) {
            d++
            end += 2.toDouble().pow(d).toInt()

            if(end >= n) {
                break
            }
        }
    }

    var start = end - 2.toDouble().pow(d).toInt() + 1

    while(start < end) {
        val mid = (start + end) / 2

        if(mid == n) {
            ans += "4"
            ans += "7".repeat(d - 1)
            break
        }else if(n < mid) {
            end = mid
            ans += "4"
        } else {
            start = mid + 1
            ans += "7"
        }

        d--
    }
    println(ans)
}
