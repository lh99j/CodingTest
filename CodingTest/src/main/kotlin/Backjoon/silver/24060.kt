import java.io.BufferedReader
import java.io.InputStreamReader


private var cnt = 0
private var time = 0
private var ans = -1
private lateinit var nums: Array<Int>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (size, c) = br.readLine().split(" ").map { it.toInt() }
    var n = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    cnt = c

    nums = Array(size){ 0 }
    merge_sort(n, 0, n.size - 1)
    println(ans)
}

private fun merge_sort(A: IntArray, low: Int, high: Int) {
    if (low < high) {
        val mid = (low + high) / 2
        merge_sort(A, low, mid)
        merge_sort(A, mid + 1, high)
        merge(A, low, mid, high)
    }
}

fun merge(A: IntArray, low: Int, mid: Int, high: Int) {
    var i = low
    var j = mid + 1
    var t = 0
    while (i <= mid && j <= high) {
        if (A[i] <= A[j]) {
           nums[t++] = A[i++]
        } else {
            nums[t++] = A[j++]
        }
    }
    while (i <= mid) {
        nums[t++] = A[i++]
    }
    while (j <= high) {
        nums[t++] = A[j++]
    }
    t = 0
    i = low
    while (i <= high) {
        time++
        if (time == cnt) {
            ans = nums[t]
            break
        }
        A[i++] = nums[t++]
    }
}