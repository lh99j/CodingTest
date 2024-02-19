import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (size, length) = br.readLine().split(" ").map { it.toInt() }
    val str = br.readLine()
    val cnt = br.readLine().split(" ").map { it.toInt() }
    var map = mutableMapOf<Char, Int>()

    map['A'] = 0
    map['C'] = 0
    map['G'] = 0
    map['T'] = 0

    var ans = 0

    for (i in 0 until length) {
        map[str[i]] = map.get(str[i])!! + 1
    }

    if (check(cnt, map.map { it.value }.toList())) {
        ans++
    }

    map[str[0]] = map.get(str[0])!! - 1

    for (i in 1..size - length) {
        map[str[i + length - 1]] = map.get(str[i + length - 1])!! + 1

        if (check(cnt, map.map { it.value }.toList())) {
            ans++
        }

        map[str[i]] = map.get(str[i])!! - 1
    }

    println(ans)
}

private fun check(validation: List<Int>, input: List<Int>): Boolean =
    validation[0] <= input[0] && validation[1] <= input[1] && validation[2] <= input[2] && validation[3] <= input[3]
