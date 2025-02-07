import java.io.BufferedReader
import java.io.InputStreamReader

private val ans = mutableListOf<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    back(0, n, 0)

    ans.sorted().forEach {
        println(it)
    }
}

private fun back(depth: Int, n: Int, cur: Int) {
    if (depth == n) {
        ans.add(cur.toInt())
        return
    }

    for (i in 1..9) {
        val nNum = cur * 10 + i

        if(isPrime(nNum)){
            back(depth + 1, n, nNum)
        }
    }
}

private fun isPrime(num: Int): Boolean {
    if(num == 1){
        return false
    }

    if(num == 2 || num == 3){
        return true
    }

    for (i in 2..num / 2) {
        if(num % i == 0){
            return false
        }
    }

    return true
}