import java.lang.Integer.min

class ChangeNum {
//    fun solution(x: Int, y: Int, n: Int): Int {
//        var answer: Int = 1
//        var array1: ArrayList<Int> = ArrayList<Int>()
//        var array2: ArrayList<Int> = ArrayList<Int>()
//        var flag: Boolean = true
//
//        if (x == y)
//            return 0
//
//        if (x + n == y) {
//            return answer
//        } else if (x + n < y) {
//            array1.add(x + n)
//        }
//
//        if (x * 2 == y) {
//            return answer
//        } else if (x * 2 < y) {
//            array1.add(x + n)
//        }
//
//        if (x * 3 == y) {
//            return answer
//        } else if (x * 3 < y) {
//            array1.add(x * 3)
//        }
//
//        while (true) {
//            array1.forEach {
//                if (it + n == y) {
//                    return answer
//                } else if (it + n < y) {
//                    array2.add(it + n)
//                }
//
//                if (it * 2 == y) {
//                    return answer
//                } else if (it * 2 < y) {
//                    array2.add(it * 2)
//                }
//
//                if (it * 3 == y) {
//                    return answer
//                } else if (it * 3 < y) {
//                    array2.add(it * 3)
//                }
//            }
//
//            if (array2.isNotEmpty()) {
//                array2 = array2.distinct() as ArrayList<Int>
//                array2.sort()
//            } else {
//                return -1
//            }
//
//            answer++
//
//            array1.clear()
//
//            array2.forEach {
//                if (it + n == y) {
//                    return answer
//                } else if (it + n < y) {
//                    array1.add(it + n)
//                }
//
//                if (it * 2 == y) {
//                    return answer
//                } else if (it * 2 < y) {
//                    array1.add(it * 2)
//                }
//
//                if (it * 3 == y) {
//                    return answer
//                } else if (it * 3 < y) {
//                    array1.add(it * 3)
//                }
//            }
//
//            if (array1.isNotEmpty()) {
//                array1 = array1.distinct() as ArrayList<Int>
//                array1.sort()
//            } else {
//                return -1
//            }
//
//            answer++
//            array1.clear()
//
//        }
//        return answer
//    }

    val MAX = 1_000_001
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0
        var dpArray = MutableList<Int>(y + 1){ MAX }

        dpArray[x] = 0

        for(i in x..y + 1){
            if(i + n <= y) {
                dpArray[i + n] = min(dpArray[i + n], dpArray[i] + 1)
            }

            if(i * 2 <= y) {
                dpArray[i * 2] = min(dpArray[i * 2], dpArray[i] + 1)
            }

            if(i * 3 <= y) {
                dpArray[i * 3] = min(dpArray[i * 3], dpArray[i] + 1)
            }
        }

        return if(dpArray[y] == MAX){
            -1
        }else{
            dpArray[y]
        }
    }
}

fun main(args: Array<String>) {
    val ch = ChangeNum()
    println(ch.solution(10, 40, 5))
    println(ch.solution(10, 40, 30))
    println(ch.solution(2, 5, 4))

}
