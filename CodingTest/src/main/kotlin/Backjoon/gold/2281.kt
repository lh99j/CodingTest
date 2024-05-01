import java.io.BufferedReader
import java.io.InputStreamReader

private const val INF = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val inputs = mutableListOf<Int>()
    val dp = Array(n) { INF }

    repeat(n) {
        inputs.add(br.readLine().toInt())
    }

    //뒤에서부터 탐색 시작
    for (i in n - 1 downTo 0) {
        //남은 노트 길이
        var p = m - inputs[i]

        //m을 넘지 않을 때 까지 이어붙이기
        for (j in i + 1 until n) {
            if(p < 0){
                break
            }

            //이어 붙이기 or 다른 페이지에 작성하기 비교
            dp[i] = minOf(dp[i], (p * p) + dp[j])

            p -= inputs[j] + 1
        }

        //모든 페이지를 이어붙여도 0보다 크다면 한 문장안에 작성 가능
        if(p >= 0){
            dp[i] = 0
        }
    }

    println(dp[0])
}