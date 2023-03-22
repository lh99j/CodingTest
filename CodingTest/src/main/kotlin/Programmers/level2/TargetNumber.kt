
class TargetNumber {
    private var cnt =  0

    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, 0, target, 0)

        return cnt
    }

    fun dfs(arr: IntArray, start: Int, target: Int, sum: Int){
        if(start == arr.size){
            if(sum == target)
                cnt++
        }else if(start < arr.size) {
            dfs(arr, start + 1, target, sum - arr[start])
            dfs(arr, start + 1, target, sum + arr[start])
        }
    }
}

fun main(args: Array<String>){
    val tn = TargetNumber()
    println(tn.solution(intArrayOf(1, 1, 1, 1, 1), 3))
}