class HanoiTower {
    private val ans: MutableList<IntArray> = mutableListOf()
    fun solution(n: Int): MutableList<IntArray> {
        hanoi(n, 1, 2, 3)

        return ans
    }

    fun hanoi(n: Int, from: Int, tmp: Int, to: Int){
        if(n == 1) ans.add(intArrayOf(from, to))
        else{
            hanoi(n - 1, from, to, tmp)
            ans.add(intArrayOf(from, to))
            hanoi(n - 1, tmp, from, to)
        }
    }
}