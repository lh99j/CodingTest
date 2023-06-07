import java.io.*
import java.util.*
import java.lang.Math.*

//private const val MAX = 1_000_000
//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val (n, count) = br.readLine().split(" ").map { it.toInt() }
//
//    val map = Array<MutableList<Int>>(n + 1) { mutableListOf() }
//
//    map[0].add(1)
//
//    for (i in 1..n) {
//        map[i].add(i + 1)
//        if (i + (i / 2) > i + 1) {
//            map[i].add(i + (i / 2))
//        }
//    }
//
//    map.forEach {
//        it.sortDescending()
//    }
//
//    bfs(map, count)
//
//}
//
//private fun bfs(map: Array<MutableList<Int>>, count: Int): Boolean {
//    val q: Queue<Dot> = LinkedList()
//
//    for (i in 0 until map[0].size) {
//        q.offer(Dot(map[0][i], 1))
//    }
//
//    while (q.isNotEmpty()) {
//        val temp = q.poll()
//
//        if(temp.y > count){
//            continue
//        }
//
//        if (temp.x == map.size - 1 && temp.y >= 0) {
//            println("minigimbob")
//            return true
//        }
//
//        if (temp.x <= map.size - 1) {
//            map[temp.x].forEach {
//                if (it < map.size) {
//                    for (i in 0 until map[it - 1].size) {
//                        q.offer(Dot(map[it - 1][i], temp.y + 1))
//                    }
//                }
//            }
//        }
//    }
//
//    println("water")
//    return false
//}

//fun main(args: Array<String>) {

//    val (n, count) = br.readLine().split(" ").map { it.toInt() }
//
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    var currentLocation = 1
//    var moveCount = 1
//
//    if (n == 0 && count > 1) {
//        println("minigimbob")
//    }else if(n == 0 && count == 0){
//        println("minigimbob")
//    }else if(n > 0 && count == 0){
//        println("water")
//    } else {
//
//        while (true) {
//            if(currentLocation == n){
//                println("minigimbob")
//                break
//            }
//
//            if (currentLocation + (currentLocation / 2) <= n && currentLocation + (currentLocation / 2) > currentLocation + 1) {
//                currentLocation += (currentLocation / 2)
//                moveCount++
//            } else {
//                currentLocation++
//                moveCount++
//            }
//
//            if (moveCount > count) {
//                println("water")
//                break
//            }
//        }
//    }
//
//}

private const val MAX = 1_000_000
fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, count) = br.readLine().split(" ").map{ it.toInt() }
    var dp = Array<Int>(MAX + 1){ 0 }

    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3

    for(i in 4..n){
        var prev = getPrevTp(i)

        if(prev + (prev / 2) == i){
            dp[i] = min(dp[prev], dp[i - 1]) + 1
        }else{
            dp[i] = dp[i - 1] + 1
        }
    }

    if(dp[n] <= count){
        println("minigimbob")
    }else{
        println("water")
    }

}

private fun getPrevTp(num: Int): Int{
    val temp = 2 * num

    if(temp % 3 == 0){
        return temp / 3
    }else{
        return (temp / 3) + 1
    }
}
