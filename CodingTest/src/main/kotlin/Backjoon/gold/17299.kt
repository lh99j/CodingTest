import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Stack

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine()
    var array = br.readLine().split(" ").map { it.toInt() }
    var stack: Stack<Int> = Stack<Int>()
    var answerArray: MutableList<Int> = MutableList<Int>(array.size) { -1 }
    var sb = StringBuilder()

    var map: MutableMap<Int, Int> = mutableMapOf()

    array.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    for (i in 0 until array.size) {
        if (stack.isEmpty()) {
            stack.push(i)
        } else {
            while (stack.isNotEmpty() && map[array[stack.peek()]]!! < map[array[i]]!!) {
                answerArray[stack.pop()] = array[i]
            }
            stack.push(i)
        }

    }

    while(stack.isNotEmpty())
        answerArray[stack.pop()] = -1

    answerArray.forEach {
        sb.append("$it ")
    }
    print(sb)
}