class FindPrime {
    private var size = 0
    private var inputs = ""
    private var ans = mutableSetOf<Int>()
    private lateinit var visited: BooleanArray
    fun solution(numbers: String): Int {
        visited = BooleanArray(numbers.length) { false }
        size = numbers.length
        inputs = numbers

        back(0, "")
        return ans.size
    }

    private fun back(depth: Int, str: String) {
        if (depth > size) {
            return
        }

        if (str != "") {
            if (isPrime(str)) ans.add(str.toInt())

        }

        for (i in 0 until size) {
            if (!visited[i]) {
                visited[i] = true
                back(depth + 1, str + inputs[i])
                visited[i] = false
            }
        }
    }

    private fun isPrime(str: String): Boolean {
        val mappingNumber = str.toInt()
        if (mappingNumber < 3) {
            return mappingNumber == 2
        }

        for (i in 2 until mappingNumber) {
            if (mappingNumber % i == 0) {
                return false
            }
        }

        return true
    }
}