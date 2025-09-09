fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    val dices = br.readLine().split(" ").map { it.toInt() }

    if(n > 1){
        var min3 = 0
        var min2 = 300
        var min1 = dices.min()
        
        // 3면
        for (i in 0..2) {
            min3 += minOf(dices[i], dices[5 - i])
        }

        for(i in 0..5) {
            for(j in 0..5) {
                if(i + j != 5 && i != j){
                    min2 = minOf(dices[i] + dices[j], min2)
                }
            }
        }

        val total3 = min3 * 4
        val total2 = min2 * ((8 * n) - 12)
        val total1 = min1 * ((5 * n * n) - (16 * n) + 12)

        println(total1 + total2 + total3)
    } else {
        println(dices.sum() - dices.max())
    }
}