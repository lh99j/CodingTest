fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toLong() }
    val inputs = br.readLine().split(" ").map { it.toLong() }
    var s: Long = 1
    var e: Long = inputs.max() + 1
    var t: Long = 0

    while(s < e) {
        val mid = (s + e) / 2
        t = 0

        inputs.forEach {
            if(mid < it) {
                t += (it - mid)
            }
        }

        if(t < m) {
            e = mid
        } else {
            s = mid + 1
        }
    }

    println(e - 1)
}
