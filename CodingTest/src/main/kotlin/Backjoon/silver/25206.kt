import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var total = 0.0
    var count = 0
    var creditTotal = 0.0

    repeat(20) {
        var splitArray = br.readLine().split(" ")
        var credit = splitArray[1].toDouble()
        var grade = splitArray[2]

        if(grade != "P"){
            var temp = when(grade){
                "A+" -> 4.5
                "A0" -> 4.0
                "B+" -> 3.5
                "B0" -> 3.0
                "C+" -> 2.5
                "C0" -> 2.0
                "D+" -> 1.5
                "D0" -> 1.0
                else -> 0.0
            }

            println(temp)

            total += (temp * credit)
            creditTotal += credit
        }
    }

    println(total / creditTotal)
}