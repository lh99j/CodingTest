import java.util.*

class RemovePair {
    fun solution(s: String): Int {
        var st = Stack<Char>()
        for (i in s) {
            if (st.isEmpty()) {
                st.push(i)
            } else {
                val p = st.peek()
                if (p == i) {
                    st.pop()
                } else {
                    st.push(i)
                }
            }
        }
        if (st.isEmpty()) {
            return 1
        } else {
            return 0
        }
    }
}

fun main() {
    val rp = RemovePair()
    println(rp.solution("baabaa"))
}