package Programmers.level2

class VisitedLength {
    data class Dot4(val x1: Int, val y1: Int, val x2: Int, val y2: Int)
    var x = 0
    var y = 0

    fun solution(dirs: String): Int{
        var answer = 0
        var dotArr = mutableListOf<Dot4>()

        for(i in dirs.indices){
            val dot4 = moveDot(dirs[i])
            if(checkDistinct(dotArr, dot4)){
                dotArr.add(dot4)
            }
        }

        return dotArr.size
    }

    fun moveDot(char: Char): Dot4{
        var px = x
        var py = y
        when(char){
            'U' -> {
                y++
            }
            'L' -> {
                x--
            }
            'R' -> {
                x++
            }
            else -> {
                y--
            }
        }

        if(x > 5){
            x = 5
        }
        if(x < -5){
            x = -5
        }
        if(y > 5){
            y = 5
        }
        if(y < -5){
            y = -5
        }

        return Dot4(px, py, x, y)
    }

    fun checkDistinct(dotList: List<Dot4>, dot4: Dot4): Boolean{
        var changeDot = Dot4(dot4.x2, dot4.y2, dot4.x1, dot4.y1)

        if(dotList.isEmpty()){
            return true
        }else{
            if(dotList.contains(dot4) || dotList.contains(changeDot) || (dot4.x1 == dot4.x2 && dot4.y1 == dot4.y2)){
                return false
            }
        }

        return true
    }
}

fun main(args: Array<String>){
    val vl = VisitedLength()
    println(vl.solution("LULLLLLLU"))
}