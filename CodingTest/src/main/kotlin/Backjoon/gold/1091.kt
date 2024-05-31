import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    var P = br.readLine().split(" ").map { it.toInt() }
    val S = br.readLine().split(" ").map { it.toInt() }

    var ans = 0

    while (ans < 200000) {
        if(check(P)){
            break
        }

        ans++
        P = shuffle(P, S)
    }

    println(if (ans == 200000) -1 else ans)
}

private fun shuffle(cards: List<Int>, S: List<Int>): List<Int> {
    var newCards = MutableList(S.size) { -1 }

    for (i in cards.indices) {
        newCards[S[i]] = cards[i]
    }

    return newCards
}

private fun check(P: List<Int>): Boolean {
    for(i in P.indices){
        if(i % 3 != P[i]){
            return false
        }
    }

    return true
}