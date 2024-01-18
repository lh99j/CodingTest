class MakeDecimalInKFormation {
    fun solution(n: Int, k: Int): Int =
        n.toString(k).split("0").filter { it.isNotEmpty() }.map { it.toLong() }.count { isPrim(it) }


    private fun isPrim(num: Long): Boolean {
        if (num == 1L) {
            return false
        }

        for (i in 2..Math.sqrt(num.toDouble()).toLong()) {
            if (num % i == 0L) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val md = MakeDecimalInKFormation()
    println(md.solution(437674, 3))
}