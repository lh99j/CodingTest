import java.io.*
import java.util.StringTokenizer

private lateinit var cities: IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val M = st.nextToken().toInt()

    cities = IntArray(N) { it }

    repeat(N) { idx ->
        st = StringTokenizer(br.readLine())

        for (j in 0 until N) {
            val value = st.nextToken().toInt()

            if (value == 1) {

                union(idx, j)
            }
        }
    }

    val check = br.readLine().split(" ").map { find(it.toInt() - 1) }.toSet()
    println(if (check.size == 1) "YES" else "NO")
}

private fun find(x: Int): Int {
    return if (x == cities[x]) {
        cities[x]
    } else {
        find(cities[x])
    }
}

private fun union(a: Int, b: Int) {
    val findA = find(a)
    val findB = find(b)

    if (findA < findB) {
        cities[findB] = findA
    } else {
        cities[findA] = findB
    }
}