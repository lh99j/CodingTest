class JadenCase {
    fun solution(s: String): String {
        var answer = ""
        var list: List<String> = s.split(" ").toList()

        for(i in list.indices){
            val str = list[i]
            if(str[0].digitToInt() in 97..122){
                str[0].uppercaseChar()
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {

}