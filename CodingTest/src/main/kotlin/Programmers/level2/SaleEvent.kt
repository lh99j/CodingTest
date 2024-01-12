class SaleEvent {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        var i = 0

        while (i <= discount.size - 10) {
            var wants = Array(want.size) { 0 }

            for (j in 0..9) {
                if (discount[i + j] in want) {
                    wants[want.indexOf(discount[i + j])]++
                }
            }

            if(number.toList() == wants){
                answer++
                if(i == 1){
                    println(wants.joinToString(" "))
                }
            }
            i++
        }

        return answer
    }
}

fun main(){
    val se = SaleEvent()
}