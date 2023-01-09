import java.io.*

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var num = br.readLine().toInt()

    var count = 1
    var plusCount = 1


    if (num != 1){
        while (count < num) {
            count += plusCount + 1
            plusCount++

        }
    }

    var temp = num - (count - plusCount)  - 1

    var a = 0
    var b = 0

    when(plusCount % 2){
        // 짝수
        0 -> {
            a = 1 + temp
            b = plusCount - temp
        }

        // 홀수
        1-> {
            a = plusCount - temp
            b = 1 + temp
        }
    }

    println("$a/$b")
}