import java.lang.Long.max

class SpliceArray {
    fun solution(n: Int, left: Long, right: Long): MutableList<Long> {
        var answer: MutableList<Int> = mutableListOf()
        var spliceArr = mutableListOf<Long>()

        for(i in left..right){
            var x = i / n
            var y = i % n

            spliceArr.add(max((x + 1), (y + 1)))
        }

        return spliceArr
    }
}

fun main(args: Array<String>){
    val sa = SpliceArray()
    println(sa.solution(3, 2, 5))
}