
fun main(args: Array<String>) {
    var answer = ""
    var str = "1 3 -1 2"
    var list: List<Int> = str.split(" ").map{ it.toInt() }.toList()
    
    answer = "${list.minOrNull()} ${list.minOrNull()}"
    println(answer)
}