import kotlin.system.exitProcess

private val map = getHashMap()
private var n = 0
private var m = 0
lateinit var x: List<Int>
lateinit var y: List<Int>
private var ans = Int.MAX_VALUE
private var s = hashSetOf<Int>()
private lateinit var selectedCnt: IntArray
private lateinit var selected: IntArray

fun main() {
    val br = System.`in`.bufferedReader()
    val map = getHashMap()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    x = br.readLine().split(" ").map { map[it]!! }
    y = br.readLine().split(" ").map { map[it]!! }
    selectedCnt = IntArray(m) { 0 }
    selected = IntArray(n) { 0 }


    back(0)
    println(ans)
}

private fun back(cur: Int) {
    if (cur == x.size) {
        for(i in selectedCnt.indices) {
            if(selectedCnt[i] == 0) {
                return
            }
        }

        for(i in 0 until x.size) {
            if(x[i] == selected[i])
                continue

            val value = if(x[i] > selected[i]) {
                (12 - x[i]) + selected[i]
            } else {
                selected[i] - x[i]
            }

            if(value != 0) {
                s.add(value)
            }
        }

        if(s.isEmpty()) {
            println(0)
            exitProcess(0)
        } else {
            ans = minOf(ans, (s.max() - s.min()) + 1)
            s.clear()
        }

        return
    }

    for (i in 0 until y.size) {
        selectedCnt[i]++
        selected[cur] = if(x[cur] > y[i]) y[i] + 12 else y[i]
        back(cur + 1)
        selected[cur] += 12
        back(cur + 1)
        selectedCnt[i]--
    }
}

private fun getHashMap(): HashMap<String, Int> = hashMapOf(
    "A" to 1,
    "A#" to 2,
    "B" to 3,
    "C" to 4,
    "C#" to 5,
    "D" to 6,
    "D#" to 7,
    "E" to 8,
    "F" to 9,
    "F#" to 10,
    "G" to 11,
    "G#" to 12
)