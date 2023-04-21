import java.text.DecimalFormat

class PersonalInfomation {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): MutableList<Int> {
        var answer: MutableList<Int> = mutableListOf()
        var dateHash: MutableMap<String, Int> = mutableMapOf()

        var splitToday = today.split(".")
        var todayYYYY = splitToday[0].toInt()
        var todayMM = splitToday[1].toInt()
        var todayDD = splitToday[2].toInt()
        var todayArray = mutableListOf<Int>()
        todayArray.add(todayYYYY)
        todayArray.add(todayMM)
        todayArray.add(todayDD)

//        for(i in terms.indices){
//            var str = ""
//            var splitTerms = terms[i].split(" ")
//            var type = splitTerms[0]
//            var num = splitTerms[1].toInt()
//            var tempYYYY = todayYYYY.toInt()
//            var tempMM = todayMM.toInt()
//            var tempDD = todayDD.toInt()
//
//            tempMM += num
//            tempDD--
//
//            if(tempMM > 12){
//                tempYYYY++
//                tempMM -= 12
//            }
//
//            if(tempDD == 0){
//                tempMM--
//                tempDD = 28
//            }
//
//            val df = DecimalFormat("00")
//
//            str = tempYYYY.toString() + df.format(tempMM) + df.format(tempDD)
//
//            dateHash[type] = str
//
//        }
//
//        println(dateHash)

        for (i in terms.indices) {
            var splitTerms = terms[i].split(" ")
            dateHash[splitTerms[0]] = splitTerms[1].toInt()
        }


        for (i in privacies.indices) {
            var splitData = privacies[i].split(" ")
            var date = splitData[0].split(".")
            var type = splitData[1]
            var yyyy = date[0].toInt()
            var mm = date[1].toInt()
            var dd = date[2].toInt()
            var num = dateHash[type]
            var str = ""

            mm += num!!
            dd--

            while(mm > 12){
                yyyy++
                mm -= 12
            }


            if (dd == 0) {
                mm--
                dd = 28
            }

            if(mm == 0){
                mm = 12
                yyyy--

            }else if(mm == -1){
                mm = 11
                yyyy--
            }

            var array = mutableListOf<Int>()
            array.add(yyyy)
            array.add(mm)
            array.add(dd)

            if(compareDate(todayArray, array)){
                answer.add(i + 1)
            }

        }

        return answer
    }

    fun compareDate(today: MutableList<Int>, compare: MutableList<Int>): Boolean{

        print(today)
        print(" ")
        print(compare)
        println()

        if(today[0] <= compare[0]){
            if(today[1] < compare[1])
                return false

            if(today[1] == compare[1] &&  today[2] <=compare[2])
                return false
        }

        return true
    }
}

fun main(args: Array<String>) {
    val pi = PersonalInfomation()
}