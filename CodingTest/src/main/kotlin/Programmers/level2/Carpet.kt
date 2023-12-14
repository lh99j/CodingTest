class Carpet {
    fun solution(brown: Int, yellow: Int): MutableList<Int> {
        var answer = mutableListOf<Int>()
        var n = brown / 2

        loop@ for (i in 1..n) {
            for (j in 1..i) {
                val b = 2 * (i + j - 2)
                val y = (i - 2) * (j - 2)
                if (b == brown && y == yellow) {
                    answer.add(i)
                    answer.add(j)
                    break@loop
                }
            }
        }
        return answer
    }
}

fun main(){
    val c = Carpet()
    println(c.solution(24, 24))
}