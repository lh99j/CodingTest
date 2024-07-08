class DivideNumberCard {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0

        var aGcd = arrayA[0]
        var bGcd = arrayB[0]

        for(i in 1 until arrayA.size){
            aGcd = gcd(aGcd, arrayA[i])
            bGcd = gcd(bGcd, arrayB[i])
        }

        if(!canDivide(arrayA, bGcd)){
            answer = maxOf(answer, bGcd)
        }

        if(!canDivide(arrayB, aGcd)){
            answer = maxOf(answer, aGcd)
        }


        return answer
    }

    private fun gcd(x: Int, y: Int): Int {
        return if (x < y) {
            if (x == 0) y else gcd(x, y % x)
        } else {
            if (y == 0) x else gcd(y, x % y)
        }
    }

    private fun canDivide(array: IntArray, gcd: Int): Boolean{
        array.forEach{
            if(it % gcd == 0){
                return true
            }
        }

        return false
    }
}