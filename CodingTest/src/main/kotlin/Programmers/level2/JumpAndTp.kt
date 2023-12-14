class JumpAndTp {
    fun solution(n: Int): Int {
        var num = n
        var cnt = 0

        while (num != 1) {
            if(num % 2 != 0){
                num -= 1
                cnt++
            }else{
                num /= 2
            }
        }

        return cnt + 1
    }
}

fun main() {
    val jat = JumpAndTp()
    println(jat.solution(5000))
}