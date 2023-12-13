class NextBiggerNumber {
    fun solution(n: Int): Int {
        var count1Number = n.toString(2).count { it == '1' }
        var cnt = n + 1

        while (true) {
            var countNew1Number = cnt.toString(2).count { it == '1' }
            if (count1Number == countNew1Number) {
                return cnt
            }
        }
    }
}