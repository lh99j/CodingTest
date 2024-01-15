class DualPriorityQueue {
    fun solution(operations: Array<String>): MutableList<Int> {
        var ans = mutableListOf<Int>()
        var arr = mutableListOf<Int>()

        for (i in operations.indices) {
            val t = operations[i].split(" ")
            var op = t[0]
            var num = t[1].toInt()

            when (op) {
                "I" -> {
                    arr.add(num)
                }

                "D" -> {
                    if (num == 1) {
                        if(arr.isNotEmpty()){
                            arr.remove(arr.maxOrNull())
                        }
                    } else {
                        if(arr.isNotEmpty()){
                            arr.remove(arr.minOrNull())
                        }
                    }
                }
            }
        }

        if(arr.isEmpty()){
            ans.add(0)
            ans.add(0)
        }else{
            ans.add(arr.maxOrNull()!!)
            ans.add(arr.minOrNull()!!)
        }

        return ans
    }
}

fun main(){
    val dpq = DualPriorityQueue()
    println(dpq.solution(arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")))
}