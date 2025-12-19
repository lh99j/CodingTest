fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M, L) = br.readLine().split(" ").map { it.toInt() }
    val inputs = if(N > 0 )br.readLine().split(" ").map { it.toInt() }.sorted().toMutableList() else mutableListOf()

    var s = 1
    var e = L
    inputs.add(0, 0)
    inputs.add(L)

    while(s < e) {
        val m = (s + e) / 2
        var cnt = 0

        for(i in 1 until inputs.size) {
            cnt += (inputs[i] - inputs[i - 1] - 1) / m
        }

        if(M >= cnt) {
            e = m
        } else {
            s = m + 1
        }
    }

    println(s)
}