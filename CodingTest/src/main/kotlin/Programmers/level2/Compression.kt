package Programmers.level2

class Compression {
    public fun solution(msg: String): MutableList<Int> {
        var answer = mutableListOf<Int>()
        var dictionary = mutableListOf<String>()
        var new = mutableListOf<String>()

        dictionary.add("null")
        for (i in 'A'..'Z') {
            dictionary.add(i.toString())
        }

        var i = 0

        while (i < msg.length) {
            i = checkCompression(msg, dictionary, new, i)
        }

        for (i in new.indices) {
            answer.add(dictionary.indexOf(new[i]))
        }

        return answer
    }

    fun checkCompression(str: String, dictionary: MutableList<String>, new: MutableList<String>, startIndex: Int): Int {
        var index = startIndex
        var mutableIndex = 0

        for (i in startIndex until str.length) {
            index = i
            var msg = str.substring(startIndex..i)

            if (!(dictionary.contains(msg))) {
                dictionary.add(msg)
                index--
                break
            }

        }

        var fstr = str.substring(startIndex..index)
        new.add(fstr)

        return index + 1
    }

}


fun main(args: Array<String>) {
    val c = Compression()
    print(c.solution("TOBEORNOTTOBEORTOBEORNOT"))
}