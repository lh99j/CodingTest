import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var num = br.readLine().toInt()
    var answer = 0

    if (num <= 99) {
        answer = num
    } else {
        answer = 99

        for (i in 100..num) {
            var temp = i
            var numList: MutableList<Int> = mutableListOf()

            while (temp > 0) {
                numList.add(temp % 10)
                temp /= 10
            }

            var checkList: MutableList<Int> = mutableListOf()

            for (i in 1 until numList.size) {
                checkList.add(numList[i] - numList[i - 1])
            }

            checkList = checkList.distinct() as MutableList<Int>

            if (checkList.size == 1) {
                answer++
            }
        }
    }

    println(answer)
}