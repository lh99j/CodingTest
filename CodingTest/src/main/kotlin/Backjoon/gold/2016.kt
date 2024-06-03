import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

private lateinit var inputs: Array<MutableList<Int>>
private var modifyCoupleIdx = 10

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(tc) {
        inputs = Array(10) { mutableListOf() }
        inputs[0].addAll(listOf(0, 0, 0, 0, 0))
        modifyCoupleIdx = 10

        repeat(9) { idx ->
            inputs[idx + 1].addAll(br.readLine().split(" ").map { it.toInt() - 1 })
        }

        var originCoupleIdx = getCoupleIdx(listOf<Int>(5, 6, 7, 8, 9))
        modifyRelation(mutableListOf())

        sb.append(if (originCoupleIdx > modifyCoupleIdx) "YES" else "NO").append("\n")
    }

    println(sb)
}

private fun getCoupleIdx(list: List<Int>): Int {
    var relations = copyRelation()
    relations[0] = list.toMutableList()
    var couples = MutableList<Pair<Int, Int>?>(5) { null }
    var isSolos = BooleanArray(5) { true }

    while (isSolos.any { it }) {
        for (i in 0 until 5) {
            if (isSolos[i]) {
                var gIdx = i + 5
                var target = relations[gIdx][0]

                if (couples[target] == null) {
                    couples[target] = Pair(gIdx, relations[target].indexOf(gIdx))
                    isSolos[i] = false
                } else if (couples[target]!!.second < relations[target].indexOf(gIdx)) {
                    relations[gIdx].removeFirst()
                } else {
                    isSolos[couples[target]!!.first - 5] = true
                    relations[couples[target]!!.first].removeFirst()
                    couples[target] = Pair(gIdx, relations[target].indexOf(gIdx))
                    isSolos[i] = false
                }
            }
        }
    }

    return couples[0]!!.first
}

private fun modifyRelation(relation: MutableList<Int>) {
    if (relation.size == 5) {
        var idx = getCoupleIdx(relation)
        modifyCoupleIdx = minOf(modifyCoupleIdx, idx)
        return
    }

    for (i in 5..9) {
        if (!relation.contains(i)) {
            relation.add(i)
            modifyRelation(relation)
            relation.removeLast()
        }
    }
}

private fun copyRelation(): Array<MutableList<Int>> {
    var relations = Array<MutableList<Int>>(10) { mutableListOf() }

    for (i in 0 until 10) {
        relations[i].addAll(inputs[i])
    }

    return relations
}
