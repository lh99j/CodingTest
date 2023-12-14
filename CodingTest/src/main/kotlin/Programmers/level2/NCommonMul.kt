class NCommonMul {
    fun solution(arr: IntArray): Int {
        var ans = arr[0]
        arr.forEach {
            ans = (ans * it) / m(ans, it)
        }
        return ans
    }

    private fun m(x: Int, y: Int): Int {
        return if(x < y){
            if(x == 0) y else m(x, y % x)
        }else{
            if(y == 0) x else m(y, x % y)
        }
    }
}

fun main() {
    val ncm = NCommonMul()
    println(ncm.solution(intArrayOf(6, 8)))
}