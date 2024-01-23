class CalculateParkingFee {
    fun solution(fees: IntArray, records: Array<String>): MutableList<Int> {
        var answer = mutableListOf<Int>()
        var parking = HashMap<String, String>()
        var feeMap = mutableMapOf<String, Int>()

        records.forEach {
            val (start, number, type) = it.split(" ")
            when (type) {
                "IN" -> {
                    parking[number] = start
                }

                "OUT" -> {
                    var (p1, p2) = parking[number]!!.split(":").map { it.toInt() }
                    var (s1, s2) = start.split(":").map { it.toInt() }
                    var m = 0
                    if (s2 >= p2) {
                        m = s2 - p2
                    } else {
                        s1--
                        m = s2 - p2 + 60
                    }
                    val time = (s1 - p1) * 60 + m

                    feeMap[number] = feeMap.getOrDefault(number, 0) + time
                    parking.remove(number)
                }
            }
        }

        parking.forEach { (key, value) ->
            var (s, m) = value.split(":").map { it.toInt() }
            val time = (23 - s) * 60 + (59 - m)
            feeMap[key] = feeMap.getOrDefault(key, 0) + time
        }


        feeMap = feeMap.toList().sortedBy { it.first.toInt() }.toMap().toMutableMap()
        feeMap.forEach { (key, value) ->
            if (value <= fees[0]) {
                answer.add(fees[1])
            } else {
                var f = fees[1] + Math.ceil(((value - fees[0]) / fees[2].toDouble())) * fees[3]
                answer.add(f.toInt())
            }
        }

        return answer
    }
}