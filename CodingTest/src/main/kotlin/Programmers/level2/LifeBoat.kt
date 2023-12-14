class LifeBoat {
    fun solution(people: IntArray, limit: Int): Int {
        val p = people.sorted()
        var s = 0
        var e = people.size - 1
        var ans = 0

        while (s < e) {
            if (p[s] + p[e] <= limit) {
                s++
                e--
                ans++
            }else{
                e--
                ans++
            }
        }

        if(s == e){
            ans++
        }

        return ans
    }
}

fun main() {
    val lb = LifeBoat()
    println(lb.solution(intArrayOf(70, 50, 80, 50), 100))
}