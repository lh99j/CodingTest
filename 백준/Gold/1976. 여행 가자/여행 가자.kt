private var p = intArrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    p = IntArray(n) { it }
    repeat(n) { x ->
        br.readLine().split(" ").map { it.toInt() }.forEachIndexed { y, value ->
            if(value == 1){
                union(x, y)
            }
        }
    }

    val size = br.readLine().split(" ").map { find(it.toInt() - 1) }.toSet().size
    val ans = if(size == 1) "YES" else "NO"
    println(ans)
}

private fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)

    p[px] = py
}

private fun find(x: Int): Int {
    if(x == p[x]) {
        return x
    }

    p[x] = find(p[x])
    return p[x]
}