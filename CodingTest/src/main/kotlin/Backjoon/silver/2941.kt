fun main(args: Array<String>) {
    val croatia: List<String> = listOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var str = readLine()!!.toString()
    var answer = 0

    for (i in croatia.indices) {
        while (str.contains(croatia[i])) {
            if(str.indexOf(croatia[i]) == 0){
                str = " " + str.substring(str.indexOf(croatia[i]) + croatia[i].length, str.length)
            }else if(str.indexOf(croatia[i]) == 1){
                str = str.substring(0, 1) + " " + str.substring(str.indexOf(croatia[i]) + croatia[i].length, str.length)
            }
            else{
                str = str.substring(0, str.indexOf(croatia[i]) - 1) + " " + str.substring(str.indexOf(croatia[i]) + croatia[i].length, str.length)
            }
            answer++
        }
    }

    for (i in 0 until str.length) {
        if (str[i] != ' ') {
            answer++
        }
    }

    println(answer)

}