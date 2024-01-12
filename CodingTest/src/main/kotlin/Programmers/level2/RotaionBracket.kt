import java.util.*

class RotaionBracket {
    fun solution(str: String): Int {
        var answer: Int = 0
        var s = str

        var i = 0
        while (i < str.length) {
            if (check(s)) {
                answer++
            }
            val temp = s[0]
            s = s.substring(1)
            s += temp

            i++
        }

        return answer
    }

    private fun check(str: String): Boolean {
        val s = Stack<Char>()

        for (i in str.indices) {
            if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
                s.push(str[i])
            }else{
                if(s.isEmpty() || (str[i] == ')' && s.peek() != '(') || (str[i] == ']' && s.peek() != '[') || (str[i] == '}' && s.peek() != '{')){
                    return false
                }else{
                    s.pop()
                }
            }
        }

        if(s.isNotEmpty()){
            return false
        }

        return true
    }
}

fun main() {
    val rb = RotaionBracket()
    println(rb.solution("[](){}"))
}