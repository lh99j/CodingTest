fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    var firstList = mutableListOf<Int>()
    var secondList = mutableListOf<Int>()
    var newFirst = mutableListOf<Int>()
    var newSecond = mutableListOf<Int>()

    repeat(n) { idx ->
        val input = br.readLine().split(" ").map { it.toInt() }
        var ans = false

        firstList.addAll(input.take(4))
        secondList.addAll(input.drop(4))

        loop@for(i in 1..4) {
            if(firstList[0] == secondList[0]) {
                newFirst.addAll(firstList.drop(1))
                newSecond.addAll(secondList.drop(1))

                for(i in 1..4) {
                    if(newFirst == newSecond) {
                        break
                    }

                    val first = newFirst.first()
                    newFirst.removeFirst()
                    newFirst.add(first)
                }

                if(newFirst == newSecond){
                    ans = true
                    break@loop
                }

                newFirst.clear()
                newSecond.clear()
            }

            if(i == 4){
                break@loop
            }

            if(i == 3){
                firstList.reverse()
            } else {
                firstList = mutableListOf(firstList[1],firstList[2],firstList[0],firstList[3])
            }
        }

        sb.append(if(ans) "1" else "0").append("\n")
        firstList.clear()
        secondList.clear()
        newFirst.clear()
        newSecond.clear()
    }

    println(sb)
}