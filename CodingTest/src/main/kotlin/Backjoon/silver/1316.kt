fun main(args: Array<String>) {
    var dupList: MutableList<Char> = mutableListOf()
    var num = readLine()!!.toInt()
    var answer = num
    var isDuple = false

    for (i in 0 until num) {
        var str = readLine()!!.toString()
        var lastWord = ' '
        dupList.clear()

        str.forEach {
            if (lastWord != it) {
                lastWord = it
                if (dupList.contains(lastWord)) {
                    isDuple = true
                } else {
                    dupList.add(lastWord)
                }
            }
        }
        if (isDuple) {
            answer--
            isDuple = false
        }
    }

    println(answer)
}