class FibonacciNumber {
    fun solution(n: Int): Int {
        var arr = Array<Int>(n + 1) { 0 }
        arr[1] = 1

        for (i in 2..n) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567
        }

        return arr[n]
    }
}

fun main() {
    val fb = FibonacciNumber()
    println(fb.solution(100))
}