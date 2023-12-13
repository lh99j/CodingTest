import java.util.*
class ValidBracket {
    fun solution(s: String): Boolean {
        val q: Queue<Char> = LinkedList()
        for(i in s.indices){
            if(s[i] == '('){
                q.offer(s[i])
            }else{
                if(q.isEmpty() || q.peek() != '('){
                    return false
                }
            }
        }

        return true
    }
}