fun main() {
    val br = System.`in`.bufferedReader()
    val arr = Array(3) { IntArray(3) }
    var sum = 0

    repeat(3) { idx ->
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        arr[idx][0] = a
        arr[idx][1] = b
        arr[idx][2] = c
    }

    //가로
    for(i in 0 until 3) {
        var total = 0

        for(j in 0 until 3) {
            total += arr[i][j]
        }

        sum = maxOf(total, sum)
    }

    //세로
    for(j in 0 until 3) {
        var total = 0

        for(i in 0 until 3) {
            total += arr[i][j]
        }

        sum = maxOf(total, sum)
    }

    //대각
    sum = maxOf(sum, arr[0][0] + arr[1][1] + arr[2][2])
    sum = maxOf(sum, arr[0][2] + arr[1][1] + arr[2][0])

    if(arr[0][0] + arr[1][1] + arr[2][2] == 0) {
        sum = arr.sumOf { it.sum() } / 2
    }

    if(arr[2][0] + arr[1][1] + arr[0][2] == 0) {
        sum = arr.sumOf { it.sum() } / 2
    }

    //0 대입하기
    for(i in 0 until 3) {
        var total = 0
        var dupleZero = false
        var zeroX = -1
        var zeroY = -1

        for(j in 0 until 3) {
            if(arr[i][j] == 0 && zeroX != -1){
                dupleZero = true
                break
            }

            if(arr[i][j] == 0) {
                zeroX = i
                zeroY = j
            }

            total += arr[i][j]
        }

        if(!dupleZero && zeroX != -1) {
            arr[zeroX][zeroY] = sum - total
        }
    }

    for(j in 0 until 3) {
        var total = 0
        var dupleZero = false
        var zeroX = -1
        var zeroY = -1

        for(i in 0 until 3) {
            if(arr[i][j] == 0 && zeroX != -1){
                dupleZero = true
                break
            }

            if(arr[i][j] == 0) {
                zeroX = i
                zeroY = j
            }

            total += arr[i][j]
        }

        if(!dupleZero && zeroX != -1) {
            arr[zeroX][zeroY] = sum - total
        }
    }

    arr.forEach {
        println(it.joinToString(" "))
    }
}