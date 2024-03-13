class EmoticonSalesDay {
    private val sales = mutableListOf<Int>()
    private val rates = intArrayOf(10, 20, 30, 40)
    private var ans = intArrayOf(0, 0)

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        back(users, emoticons)

        return ans
    }

    private fun back(users: Array<IntArray>, emoticons: IntArray){
        if(sales.size == emoticons.size){
            var sub = 0
            var tp = 0

            users.forEach{ (rate, price) ->
                var total = 0

                sales.forEachIndexed{ idx, value ->
                    if(rate <= value){
                        total += emoticons[idx] * (100 - value) / 100
                    }
                }

                if(total >= price){
                    sub++
                }else{
                    tp += total
                }
            }

            if(ans[0] < sub){
                ans[0] = sub
                ans[1] = tp
            }else if(ans[0] == sub && ans[1] < tp){
                ans[0] = sub
                ans[1] = tp
            }

            return
        }

        for(i in 0..3){
            sales.add(rates[i])
            back(users, emoticons)
            sales.removeLast()
        }
    }
}