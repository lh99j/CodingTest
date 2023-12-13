class NumberExpression {
    fun solution(n: Int): Int {
        var cnt = 0
        for (i in 1..n) {
            var acc = 0
            for (j in i..n) {
                acc += j
                if(acc == n){
                    cnt++
                }
                if(acc > n){
                    continue
                }
            }
        }

        return cnt
    }
}

fun main() {
    val ne = NumberExpression()
    println(ne.solution(15))
}