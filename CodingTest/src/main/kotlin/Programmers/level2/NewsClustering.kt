class NewsClustering {
    fun solution(str1: String, str2: String): Int {
        var s1 = makeArr(str1)
        var s2 = makeArr(str2)

        var union = 0
        var intersect = 0

        var s1M = HashMap<String, Int>()
        var s2M = HashMap<String, Int>()

        s1.forEach {
            s1M[it] = s1M.getOrDefault(it, 0) + 1
        }

        s2.forEach {
            s2M[it] = s2M.getOrDefault(it, 0) + 1
        }

        s1M.forEach { (key, value) ->
            if (key in s2M) {
                intersect += minOf(value, s2M[key]!!)
                union += maxOf(value, s2M[key]!!)
            } else {
                union += value
            }
        }

        s2M.forEach { (key, value) ->
            if (key !in s1M) {
                union += value
            }
        }

        return if (intersect == 0 && union == 0) {
            65536
        } else {
            ((intersect.toDouble() / union.toDouble()) * 65536).toInt()
        }
    }

    private fun makeArr(str: String): List<String> {
        var strArr = mutableListOf<String>()
        for (i in str.indices) {
            if (i + 1 < str.length && str.substring(i, i + 2).matches(Regex("^[a-zA-Z]+$"))) {
                strArr.add(str.substring(i, i + 2).uppercase())
            }
        }

        return strArr
    }
}

fun main() {
    val nc = NewsClustering()
    println(nc.solution("AAbbaa_AAbb", "BBB"))
}