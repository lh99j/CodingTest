class BinaryRepeat {
    fun solution(s: String): MutableList<Int> {
        var answer = mutableListOf<Int>()
        var str = s
        var zeroCount = 0
        var cnt = 0

        while (str != "1") {
            zeroCount += str.count { it == '0' }
            val c = str.count { it == '1' }
            str = c.toString(2)
            cnt++
        }

        answer.add(cnt)
        answer.add(zeroCount)

        return answer
    }
}

fun main(){
    val br = BinaryRepeat()
    println(br.solution("110010101001").joinToString(" "))
}