import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.StringTokenizer

//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val tc = br.readLine().toInt()
//    val sb = StringBuilder()
//
//    repeat(tc) {
//        var mines = Array(10_001) { BooleanArray(10_001) { false } }
//        var ans = 0
//
//        repeat(br.readLine().toInt()) {
//            var (x, y) = br.readLine().split(" ").map { it.toInt() }
//            mines[x][y] = true
//        }
//
//        for(i in 0..9990){
//            for(j in 0..9990){
//                ans = maxOf(ans, countMines(mines, i, j))
//            }
//        }
//
//        sb.append(ans).append("\n")
//    }
//
//    println(sb)
//}
//
//private fun countMines(mines: Array<BooleanArray>, x: Int, y: Int): Int{
//    var cnt = 0
//
//    for(i in 0..10){
//        for(j in 0..10){
//            if(mines[i + x][j + y]){
//                cnt++
//            }
//        }
//    }
//
//    return cnt
//}

private val range = 0 until 10000
private var mines = Array(10_000) { IntArray(10_000) { 0 } }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(tc) {
        repeat(br.readLine().toInt()){
            var st = StringTokenizer(br.readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()
            for(i in x..(x + 10)){
                for(j in y..(y + 10)){
                    if(validPosition(i, j)){
                        mines[i][j]++
                    }
                }
            }
        }

        bw.write("${mines.maxOf { row -> row.maxOrNull()!! }}\n")
        mines.forEach { it.fill(0) }
    }

    bw.flush()
    bw.close()
}

private fun validPosition(x: Int, y: Int) = x in range && y in range