class TwinSiso {
    fun solution(w: IntArray): Long {
        var answer: Long = 0
        val map = mutableMapOf<Double, Int>()
        val weights = w.sorted()

        weights.forEach{
            val a = it * 1.0
            val b = it * 1.0 / 2.0
            val c = it * 2.0 / 3.0
            val d = it * 3.0 / 4.0

            if(map.contains(a)) answer += map[a]!!
            if(map.contains(b)) answer += map[b]!!
            if(map.contains(c)) answer += map[c]!!
            if(map.contains(d)) answer += map[d]!!


            map[it.toDouble()] = map.getOrDefault(it.toDouble(), 0) + 1
        }

        return answer
    }
}