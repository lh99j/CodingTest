import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()

    var answer = -1
    var b = 5
    var i = 1

    while(true){
        b = 5 * i
        if(b > num){
            break
        }
//        println("b : $b")
        var remainder = num - b
//        println("remainder : $remainder")

        if(num % b == 0){
            answer = i
        }

        if(remainder % 3 == 0){

            answer = i + (remainder / 3)
//            println(answer)
        }

        i++
    }

    var tmp = -1

    if(num % 3 == 0) {
        tmp = num / 3
    }

    if(tmp != -1 && answer == -1){
        answer = tmp
    }

    println(answer)

}