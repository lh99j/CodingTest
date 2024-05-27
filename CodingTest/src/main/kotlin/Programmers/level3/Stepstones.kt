import java.util.*

class Stepstones {
    private data class Stepstone(val value: Int, val idx: Int)

    fun solution(stones: IntArray, k: Int): Int{
//        return slidingWindow(stones, k)
        return binarySearch(stones, k)
    }

    // 슬라이딩 윈도우 + 덱 이용
    private fun slidingWindow(stones: IntArray, k: Int): Int {
        var ans = 200_000_001
        var window: Deque<Stepstone> = LinkedList()

        if(k == 1 || stones.size < k){
            return stones.minOrNull()!!
        }else if(stones.size == 1){
            return stones[0]
        }

        for(i in 0 until k - 1){
            while (window.isNotEmpty() && window.last().value < stones[i]) {
                window.removeLast()
            }

            window.addLast(Stepstone(stones[i], i))
        }


        for(i in k - 1 until stones.size){
            while (window.isNotEmpty() && window.last().value < stones[i]) {
                window.removeLast()
            }

            window.addLast(Stepstone(stones[i], i))

            if (window.first.idx < i - k + 1){
                window.removeFirst()
            }

            ans = minOf(ans, window.first.value)
        }

        return ans
    }


    //이진 탐색 이용 풀이
    private fun binarySearch(stones: IntArray, k: Int): Int{
        var left = 0
        var right = 200_000_000

        while(left <= right){
            val mid = (left + right) / 2

            if(check(stones, mid, k)){
                left = mid + 1
            }else{
                right = mid
            }
        }

        return left
    }

    private fun check(stones: IntArray, mid: Int, k: Int): Boolean{
        var cnt = 0

        for(i in stones.indices){
            if(stones[i] < mid){
                cnt++
            }else{
                cnt = 0
            }

            if(cnt == k){
                return false
            }
        }

        return true
    }
}