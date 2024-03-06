import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (cnt, price) = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Pair<Int, Int>>()
    var ans = 0

    // Pair(5000원 음식 만족도, 1000원 음식 만족도)를 리스트에 추가.
    repeat(cnt) {
        val (price5000, price1000) = br.readLine().split(" ").map { it.toInt() }
        list.add(Pair(price5000, price1000))
    }

    // (A - B)를 기준으로 내림차순 정렬, 만약 그 차이가 같다면 A가 기준.
    val sortedList =
        list.sortedWith(compareByDescending<Pair<Int, Int>> { it.first - it.second }.thenByDescending { it.first })

    sortedList.forEachIndexed { idx, value ->
        // 앞으로 남은 날짜
        var day = cnt - idx - 1

        // A - B의 차이
        var gap = value.first - value.second

        // 차이가 음수라면 무조건 1000원짜리 음식 선택
        if (gap <= 0) {
            price -= 1000
            ans += value.second

            //만약 오늘 5000원짜리 음식을 먹었을 때 남은 날 모든 음식을 1000원짜리 음식을 먹을 수 있다면
        } else if (price - 5000 >= day * 1000) {
            price -= 5000
            ans += value.first
        }else{
            price -= 1000
            ans += value.second
        }
    }

    println(ans)
}