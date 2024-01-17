class Prefix {
    fun solution(phone_book: Array<String>): Boolean {
        val pb = phone_book.sortedBy { it.length }
        var maxL = pb[pb.size - 1].length
        var minL = pb[0].length

        if (phone_book.size == 1) {
            return true
        } else {
            for (i in minL..maxL) {
                var strArr = HashSet<String>()
                var validationArr = HashSet<String>()

                pb.forEach {
                    if(it.length > i){
                        strArr.add(it.substring(0, i))
                    }else if(it.length == i){
                        validationArr.add(it)
                    }
                }

                validationArr.forEach {
                    if(it in strArr){
                        return false
                    }
                }
            }
        }
        return true
    }
}

fun main() {
    val p = Prefix()
    println(p.solution(arrayOf("12","123","1235","567","88")))
}