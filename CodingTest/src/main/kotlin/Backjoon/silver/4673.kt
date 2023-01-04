import java.io.BufferedReader

fun main(args: Array<String>) {
    var selfList: MutableList<Int> = MutableList(10000) { i -> i + 1 }

    for (i in 1..10000) {
        var temp = i
        var value = i

        while (temp > 0) {
            value += temp % 10
            temp /= 10
        }

        selfList.remove(value)
    }


    for (i in 0 until selfList.size)
        println(selfList[i])

}