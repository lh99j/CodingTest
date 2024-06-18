import java.io.*
import java.util.StringTokenizer

private lateinit var map: HashMap<String, String>
private lateinit var cntMap: HashMap<String, Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val tc = st.nextToken().toInt()

    repeat(tc) {
        st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        map = hashMapOf()
        cntMap = hashMapOf()

        repeat(N) { idx ->
            st = StringTokenizer(br.readLine())

            val a = st.nextToken()
            val b = st.nextToken()
            map[a] = map.getOrDefault(a, a)
            cntMap[a] = cntMap.getOrDefault(a, 1)

            map[b] = map.getOrDefault(b, b)
            cntMap[b] = cntMap.getOrDefault(b, 1)

            union(a, b)
            bw.write("${cntMap[find(a)]}\n")
        }
    }

    bw.flush()
    bw.close()
}

private fun find(name: String): String {
    if(name != map[name]){
        map[name] = find(map[name]!!)
    }

    return map[name]!!
}

private fun union(a: String, b: String){
    val findA = find(a)
    var findB = find(b)

    if(findA != findB) {
        if(cntMap[findA]!! < cntMap[findB]!!){
            map[findA] = map[findB]!!
            cntMap[findB] = cntMap[findA]!! + cntMap[findB]!!
        }else{
            map[findB] = map[findA]!!
            cntMap[findA] = cntMap[findA]!! + cntMap[findB]!!
        }
    }
}