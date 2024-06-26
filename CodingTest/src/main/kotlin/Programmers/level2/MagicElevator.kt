class MagicElevator {
    private val up = 6..9
    fun solution(storey: Int): Int {
        var ans: Int = 0
        var n = storey

        while (n >= 10) {
            val cur = n % 10
            n /= 10

            if (cur in up) {
                n++
                ans += 10 - cur
            } else if (cur == 5) {
                var next = n % 10

                if (next in 5..9) {
                    n++
                    ans += 10 - cur
                } else {
                    ans += cur
                }
            } else {
                ans += cur
            }
        }

        if (n in up) {
            ans += 10 - n + 1
        } else {
            ans += n
        }

        return ans
    }
}