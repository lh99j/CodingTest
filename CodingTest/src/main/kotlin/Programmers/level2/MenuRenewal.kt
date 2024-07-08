class MenuRenewal {
    private val alpha = Array<String>(26) { (it + 65).toChar().toString() }
    private lateinit var orders: Array<String>
    private val temp = mutableListOf<String>()
    private var total = -1

    fun solution(o: Array<String>, course: IntArray): List<String> {
        var answer = mutableListOf<String>()
        orders = o

        course.forEach{
            total = -1
            temp.clear()

            back(0, it, 0, "")

            answer.addAll(temp)
        }

        return answer.sorted()
    }

    private fun back(cur: Int, depth: Int, start: Int,  str: String){
        if(depth == cur) {
            check(str)

            return
        }

        for(i in start until alpha.size){
            back(cur + 1, depth, i + 1, str + alpha[i])
        }
    }

    private fun check(str: String){

        var cnt = 0

        for(i in orders.indices){
            if(orders[i].length < str.length){
                continue
            }

            var tc = 0

            for(c in str){
                if(c in orders[i]){
                    tc++
                }
            }

            if(tc == str.length){
                cnt++
            }
        }

        if(cnt <= 1){
            return
        }

        if(cnt > total){
            temp.clear()
            temp.add(str)
            total = cnt
        }else if(cnt == total){
            temp.add(str)
        }
    }
}