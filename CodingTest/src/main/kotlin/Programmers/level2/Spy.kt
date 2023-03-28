class Spy {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var hash: MutableMap<String, Int> = mutableMapOf()
        
        clothes.forEach {
            hash[it[1]] = hash.getOrDefault(it[1], 0) + 1
        }

        hash.forEach{
            answer *= (it.value + 1)
        }



        return answer - 1
    }
}

fun main(args: Array<String>){
    val spy = Spy()
}