import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    var chess = Array<MutableList<Char>>(x){ mutableListOf() }

    var i = 0
    repeat(x){
        var arr = br.readLine().toCharArray().toList()

        chess[i].addAll(arr)
        i++
    }

    var answer = mutableListOf<Int>()

    for(i in 0 until x - 7){
        for(j in 0 until y - 7){
            var count1 = 0
            var count2 = 0
            for(k in 0 until 8){
                for(w in 0 until 8){
                    if(k % 2 == 0 && w % 2 == 0){
                        if(chess[k + i][w + j] == 'B'){
                            count1++
                        }else{
                            count2++
                        }
                    }else if(k % 2 != 0 && w % 2 == 0){
                        if(chess[k + i][w + j] == 'W'){
                            count1++
                        }else{
                            count2++
                        }
                    }else if(k % 2 == 0 && w % 2 != 0){
                        if(chess[k + i][w + j] == 'W'){
                            count1++
                        }else{
                            count2++
                        }
                    }else if(k % 2 != 0 && w % 2 != 0){
                        if(chess[k + i][w + j] == 'B'){
                            count1++
                        }else{
                            count2++
                        }
                    }
                }
            }

            answer.add(count1)
            answer.add(count2)
        }
    }

    if(answer.size == 0){
        println(0)
    }else {
        println(answer.min())
    }
}