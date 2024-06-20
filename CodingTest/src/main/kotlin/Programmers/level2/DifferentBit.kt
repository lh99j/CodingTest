class DifferentBit {
    fun solution(numbers: LongArray): MutableList<Long> {
        val ans = mutableListOf<Long>()

        for(i in numbers.indices){
            if(numbers[i] == 0L){
                ans.add(1L)
                continue
            }

            var binary = numbers[i].toString(2)
            val length = binary.length

            if(binary[length - 1] == '0'){
                binary = binary.substring(0, length - 1) + "1"
            }else if(binary.contains('0')){
                val idx = binary.lastIndexOf('0')
                binary = binary.replaceRange(idx, idx + 1, "10")
            } else{
                binary = "10" + binary.substring(1, length)
            }

            ans.add(binary.toLong(2))
        }

        return ans
    }
}