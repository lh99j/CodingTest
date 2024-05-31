import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.Box

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, w, b) = br.readLine().split(" ").map { it.toInt() }
    val blocks: Array<MutableList<MutableList<Int>>> = Array(n) { mutableListOf() }
    var box = Array(b) { Array(w) { 0 } }
    val sb = StringBuilder()

    repeat(n) { idx ->
        val height = br.readLine().toInt()
        blocks[idx] = MutableList(height) { MutableList(w) { 0 } }

        for (i in height - 1 downTo 0) {
            var inputs = br.readLine()

            for (j in inputs.indices) {
                if (inputs[j] == 'X') {
                    blocks[idx][i][j] = 1
                } else {
                    blocks[idx][i][j] = 0
                }
            }
        }
    }


    repeat(n) { idx ->
        var isPack = false

        for (i in 0 until b) {
            if (isValid(blocks[idx], box, i)) {
                packing(blocks[idx], box, i)
                isPack = true
                break
            }
        }

        if(!isPack){
            val h = box.count { it.any { it == 1 } }
            sb.append(h).append(" ")
            clear(box)
            packing(blocks[idx], box, 0)
        }
    }

    sb.append(box.count { it.any { it == 1 } }).append(" ")

    println(sb)
}


private fun isValid(block: MutableList<MutableList<Int>>, box: Array<Array<Int>>, height: Int): Boolean {
    for (i in 0 until block.size) {

        if(i + height !in box.indices){
            return false
        }

        for (j in 0 until block[0].size) {
            if (block[i][j] == 1 && box[i + height][j] == 1) {
                return false
            }
        }
    }

    return true
}

private fun clear(box: Array<Array<Int>>) {
    for (i in 0 until box.size) {
        for (j in 0 until box[0].size) {
            box[i][j] = 0
        }
    }
}

private fun packing(block: MutableList<MutableList<Int>>, box: Array<Array<Int>>, height: Int) {
    for (i in 0 until block.size) {
        for (j in 0 until block[0].size) {
            if (block[i][j] == 1) {
                box[i + height][j] = 1
            }
        }
    }
}