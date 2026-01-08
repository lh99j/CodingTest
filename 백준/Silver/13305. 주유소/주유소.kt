fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val d = br.readLine().split(" ").map { it.toInt() }
    val p = br.readLine().split(" ").map { it.toLong() }
    var ans = p[0] * d[0]
    var c = p[0]

    for(i in 1 until n - 1) {
        if(p[i] < c) {
            c = p[i]
        }

        ans += c * d[i]
    }

    println(ans)
}