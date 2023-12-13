class JadenCase {
    fun solution(s: String): String {
        var strings = s.split(" ")
        var new = mutableListOf<String>()

        for (i in strings.indices) {
            val str = strings[i]
            if (str.isNotEmpty()) {
                var newS = ""
                newS += str[0].uppercaseChar()
                if (str.length > 1) {
                    newS += str.substring(1, str.length).lowercase()
                }
                new.add(newS)
            }else {
                new.add(str)
            }
        }


        return new.joinToString(" ")
    }
}

fun main(args: Array<String>) {
    val jc = JadenCase()
    println(jc.solution("  for the what 1what  "))
}