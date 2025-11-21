fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    val ans = br.readLine().split(" ").map { it.toInt() }

    ans.forEach {
        println(if(binarySearch(inputs, it)) 1 else 0)
    }
}

private fun binarySearch(inputs: List<Int>, search: Int): Boolean {
    var start = 0
    var end = inputs.size - 1

    while(start <= end) {
        val mid = (start + end) / 2
        
        if(inputs[mid] > search) {
            end = mid - 1
        } else if(inputs[mid] < search) {
            start = mid + 1
        } else {
            return true
        }
    }

    return false
}
