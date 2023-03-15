class GetReport {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): List<Int> {
        var idMap = mutableMapOf<String, Int>()
        var reportArray = report.distinct()
        var reportMap = mutableMapOf<String, Int>()

        id_list.forEach {
            idMap[it] = idMap.getOrDefault(it, 0)
        }

        println(idMap)

        reportArray.forEach {
            var rp = it.split(" ")
            var reported = rp[1]
            reportMap[reported] = reportMap.getOrDefault(reported, 0) + 1
        }

        reportArray.forEach {
            var temp = it.split(" ")
            var reporter = temp[0]
            var reported = temp[1]

            if(reportMap[reported]!! >= k){
                idMap[reporter] = idMap[reporter]!! + 1
            }
        }

        return idMap.toList().map { it.second }
    }
}

fun main(args: Array<String>){
    val gr = GetReport()
    println(gr.solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"), 2))


}