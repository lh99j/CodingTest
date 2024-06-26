import java.lang.StringBuilder

class CountryOf124 {
    fun solution(n: Int): String {
        val sb = StringBuilder()
        var number = n

        while(number > 3){
            if (number % 3 == 0){
                sb.append("4")

                number = number / 3 - 1
            }else{
                sb.append("${number % 3}")

                number /= 3
            }
        }

        sb.append("${if(number == 3) 4 else number}")

        return sb.reversed().toString()
    }
}

fun main(){
    val c = CountryOf124()
    println(c.solution(600))
}