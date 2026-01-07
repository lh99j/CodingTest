fun main() {
    val br = System.`in`.bufferedReader()
    val inputs = br.readLine()
    val m = inputs.split("-")
    val t = mutableListOf<Int>()

    m.forEach {
        val s = it.split("+").map { it.toInt() }
        t.add(s.sum())
    }

    var ans = t[0]
    for(i in 1 until t.size) {
        ans -= t[i]
    }

    println(ans)
}