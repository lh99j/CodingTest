class NumberGame {
    fun solution(n: Int, t: Int, m: Int, p: Int): String {
        var answer = ""
        var arr = mutableListOf<String>()

        arr.add("0")

        for (i in 1..t * m) {
            arr.addAll(makeArray(i, n))
        }

        var turn = p - 1

        for (i in turn..arr.size step (m)) {
            answer += arr[i]

            if (answer.length == t) {
                break
            }
        }

        return answer
    }

    fun makeArray(number: Int, n: Int): MutableList<String> {
        var arr = mutableListOf<String>()
        var num = number

        while (true) {
            var tmp = num % n
            num /= n

            arr.add(pasingNumber(tmp, n))

            if (num < n) {
                arr.add(pasingNumber(num, n))
                break
            }
        }

        arr.reverse()

        if (arr[0] == "0") {
            arr.removeAt(0)
        }
        return arr
    }

    fun pasingNumber(number: Int, n: Int): String {

        if (n != 10) {
            if (number == 10) {
                return "A"
            } else if (number == 11) {
                return "B"
            } else if (number == 12) {
                return "C"
            } else if (number == 13) {
                return "D"
            } else if (number == 14) {
                return "E"
            } else if (number == 15) {
                return "F"
            } else if (number < 10) {
                return number.toString()
            }
        }

        return number.toString()
    }
}

fun main(args: Array<String>) {
    val ng = NumberGame()

    println(ng.solution(16, 16, 2, 2))
}

