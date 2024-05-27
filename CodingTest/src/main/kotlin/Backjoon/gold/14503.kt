import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 0 : 북, 1 : 동, 2: 남, 3 : 서  ([북, 동, 남, 서])
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    var (x, y, direction) = br.readLine().split(" ").map { it.toInt() }
    var room = Array<MutableList<Int>>(N){ mutableListOf() }
    var ans = 0

    repeat(N) { idx ->
        val inputs = br.readLine().split(" ").map { it.toInt() }
        room[idx].addAll(inputs)
    }

    while(x in 0 until N && y in 0 until M && room[x][y] != 1){
        var cleanable = false
        // 1. 청소한다.
        if(room[x][y] == 0){
            ans++
            room[x][y] = 1 + ans
        }

        // 2. 4방향을 확인하여 청소칸이 있는지 확인한다.
        for(temp in 0..3){
            direction = if(direction == 0) 3 else direction - 1

            val nx = x + dx[direction]
            val ny = y + dy[direction]

            // 3. 만약 청소되지 않은 칸이 존재한다면 ? -> 반시계 방향으로 90도 이동한다.
            if(nx in 0 until N && ny in 0 until M && room[nx][ny] == 0){
                x = nx
                y = ny

                cleanable = true
                break
            }
        }

        // 4. 만약 모든 칸이 청소됐다면 -> 후진한다.
        if(!cleanable){
            val oppositeDirection = getOppositeDirection(direction)
            x += dx[oppositeDirection]
            y += dy[oppositeDirection]
        }

    }

    println(ans)
}

private fun getOppositeDirection(d: Int): Int{
    return when(d){
        0 -> 2
        1 -> 3
        2 -> 0
        3 -> 1
        else -> -1
    }
}