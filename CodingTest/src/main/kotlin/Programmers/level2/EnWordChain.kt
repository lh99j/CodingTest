class EnWordChain {
    fun solution(n: Int, words: Array<String>): MutableList<Int> {
        val answer = mutableListOf<Int>()
        val chain = mutableListOf<String>()
        chain.add(words[0])

        for (i in 1 until words.size) {
            val word = words[i]
            val preWord = words[i - 1]

            if (word.first() != preWord.last() || word in chain) {
                answer.add((i % n) + 1)
                answer.add((i / n) + 1)
                break
            }

            chain.add(word)
        }

        if(answer.isEmpty()){
            answer.add(0)
            answer.add(0)
        }

        return answer
    }
}