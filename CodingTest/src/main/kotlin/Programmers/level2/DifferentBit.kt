class DifferentBit {
    fun solution(numbers: LongArray): MutableList<Long> {
        val ans = mutableListOf<Long>()

        for(i in numbers.indices){
            if(numbers[i] == 0L){
                ans.add(1L)
                continue
            }
            var binary = numbers[i].toString(2)
            if(binary[binary.length - 1] == '0'){
                binary = binary.substring(0, binary.length - 1) + "1"
            }else{
                var indexFirst1 = -1

                for(i in binary.indices){
                    if(binary[i] == '1'){
                        indexFirst1 = i
                        break
                    }
                }

                var index0 = -1

                for(i in indexFirst1 until binary.length){
                    if(binary[i] == '0'){
                        index0 = i
                    }
                }

                if(index0 == -1){
                    binary = "10" + binary.substring(1, binary.length)
                }else{
                    var search1 = -1

                    for(i in index0 until binary.length){
                        if(binary[i] == '1'){
                            search1 = i
                            break
                        }
                    }

                    binary = binary.substring(0, index0) + "10" + binary.substring(search1 + 1, binary.length)
                }
            }

            ans.add(binary.toLong(2))
        }

        return ans
    }
}