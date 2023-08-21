class NumberGame {
    fun solution(n: Int, t: Int, m: Int, p: Int): String {
        var answer = ""
        var arr = mutableListOf<String>()

        arr.add("0")
        for (i in 1..t * m) {
            if(n != 10) {
                arr.addAll(makeArray(i, n))
            }else if(n == 10){
                arr.addAll(makeArrayByOctal(i))
            }
        }

        var turn = m - p - 1

        if(turn < 0){
            turn = m - 1
        }
        for (i in turn..arr.size step (m)) {
            answer += arr[i]

            if(answer.length == t){
                break
            }
        }

//        println(arr.toList().toString())
        return answer
    }

    fun makeArray(number: Int, n: Int): MutableList<String> {
        var arr = mutableListOf<String>()
        var num = number

        while (true) {
            var tmp = num % n
            num /= n
            if (tmp == 10) {
                arr.add("A")
            } else if (tmp == 11) {
                arr.add("B")
            } else if (tmp == 12) {
                arr.add("C")
            } else if (tmp == 13) {
                arr.add("D")
            } else if (tmp == 14) {
                arr.add("E")
            } else if (tmp == 15) {
                arr.add("F")
            } else if (tmp < 10) {
                arr.add(tmp.toString())
            }

            if (num < n) {

                if (num == 10) {
                    arr.add("A")
                } else if (num == 11) {
                    arr.add("B")
                } else if (num == 12) {
                    arr.add("C")
                } else if (num == 13) {
                    arr.add("D")
                } else if (num == 14) {
                    arr.add("E")
                } else if (num == 15) {
                    arr.add("F")
                } else if (num < 10) {
                    arr.add(num.toString())
                }

                break
            }
        }

        arr.reverse()

        if(arr[0] == "0"){
            arr.removeAt(0)
        }
        return arr
    }

    fun makeArrayByOctal(number: Int): MutableList<String>{
        var num = number
        var arr = mutableListOf<String>()

        while(true){
            var tmp = num % 10
            arr.add(tmp.toString())
            num /= 10

            if(num < 10){
                arr.add(num.toString())
                break
            }
        }

        arr.reverse()

        return arr
    }
}

fun main(args: Array<String>) {
    val ng = NumberGame()

    println(ng.solution(16, 16, 2, 2))
}

