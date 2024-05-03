import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    var dp = Array(N + 1) { 0 }
    val subjects = Array<MutableList<Int>>(N + 1) { mutableListOf() }

    repeat(M) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        subjects[end].add(start)
    }

    for(i in 1..N){
        if(subjects[i].isEmpty()) {
            dp[i] = 1
        } else{
            var max = 0

            for(j in subjects[i].indices){
                max = maxOf(max, dp[subjects[i][j]])
            }

            dp[i] = max + 1
        }
    }

    for(i in 1..N){
        print("${dp[i]} ")
    }
}