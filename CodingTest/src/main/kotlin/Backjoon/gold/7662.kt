import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.PriorityQueue
import java.util.TreeMap

//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val sb = StringBuilder()
//
//    repeat(br.readLine().toInt()) {
//        var minQ = PriorityQueue<Int>()
//        var maxQ = PriorityQueue<Int>(reverseOrder())
//        var vm = hashMapOf<Int, Int>()
//        var vn = hashMapOf<Int, Int>()
//
//        repeat(br.readLine().toInt()) {
//            var (op, num) = br.readLine().split(" ")
//
//            when (op) {
//                "I" -> {
//                    maxQ.offer(num.toInt())
//                    minQ.offer(num.toInt())
//                }
//
//                "D" -> {
//                    if (maxQ.isNotEmpty() && num == "1") {
//                        removeQ(maxQ, vn, vm)
//                    } else if (minQ.isNotEmpty() && num == "-1") {
//                        removeQ(minQ, vm, vn)
//                    }
//                }
//            }
//        }
//
//        sync(maxQ, vn)
//        sync(minQ, vm)
//
//        if (maxQ.isEmpty() || minQ.isEmpty()) {
//            sb.append("EMPTY").append("\n")
//        } else {
//            sb.append("${maxQ.poll()} ${minQ.poll()}").append("\n")
//        }
//
//    }
//
//    println(sb)
//}
//
//private fun removeQ(q: PriorityQueue<Int>, v1: HashMap<Int, Int>, v2: HashMap<Int, Int>) {
//    while (q.peek() in v1) {
//        val t = q.poll()
//        v1[t] = v1[t]!! - 1
//        if (v1[t]!! == 0) {
//            v1.remove(t)
//        }
//    }
//
//    if (q.isNotEmpty()) {
//        val t = q.poll()
//        v2[t] = v2.getOrDefault(t, 0) + 1
//    }
//}
//
//private fun sync(q: PriorityQueue<Int>, v: HashMap<Int, Int>) {
//    while (true) {
//        if (q.isEmpty()) {
//            return
//        } else {
//            if (q.peek() in v) {
//                val t = q.poll()
//                v[t] = v[t]!! - 1
//                if (v[t]!! == 0) {
//                    v.remove(t)
//                }
//            } else {
//                return
//            }
//        }
//    }
//}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    repeat(br.readLine().toInt()) {
        var tm = TreeMap<Int, Int>()

        repeat(br.readLine().toInt()) {
            val t = br.readLine().split(" ")
            val op = t[0]
            val num = t[1].toInt()

            when (op) {
                "I" -> {
                    tm[num] = tm.getOrDefault(num, 0) + 1
                }

                "D" -> {
                    if (tm.isNotEmpty() && num == 1) {
                        val k = tm.lastKey()
                        removeK(tm, k)
                    } else if (tm.isNotEmpty() && num == -1) {
                        val k = tm.firstKey()
                        removeK(tm, k)
                    }
                }
            }
        }

        if(tm.isEmpty()){
            sb.append("EMPTY").append("\n")
        }else if(tm.size == 1){
            sb.append("${tm.firstKey()} ${tm.firstKey()}").append("\n")
        }else{
            sb.append("${tm.lastKey()} ${tm.firstKey()}").append("\n")
        }
    }

    println(sb)
}

private fun removeK(map: TreeMap<Int, Int>, key: Int) {
    map[key] = map[key]!! - 1
    if (map[key] == 0) {
        map.remove(key)
    }
}