import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    class Gear(val str: String) {
        var gears: MutableList<Int> = str.chunked(1).map { it.toInt() }.toMutableList()

        fun move(direction: Int) {
            when (direction) {
                //반시계
                -1 -> {
                    val temp = gears.removeFirst()
                    gears.add(gears.size, temp)
                }

                //시계
                1 -> {
                    val temp = gears.removeLast()
                    gears.add(0, temp)
                }
            }
        }
    }

    val br = BufferedReader(InputStreamReader(System.`in`))
    val gear = mutableListOf<Gear>()

    repeat(4) {
        gear.add(Gear(br.readLine()))
    }

    val cnt = br.readLine().toInt()
    repeat(cnt) { idx ->
        var (number, direction) = br.readLine().split(" ").map { it.toInt() }
        var direction2 = direction

        gear[number - 1].move(direction)

        var rf = false
        for (i in number until gear.size) {
            if (rf) {
                break
            }

            //시계방향, 오른쪽
            if (direction == 1) {
                if (gear[i - 1].gears[3] != gear[i].gears[6]) {
                    direction *= -1
                    gear[i].move(direction)
                } else {
                    rf = true
                }
                //반 시계방향, 왼쪽
            } else {
                if (gear[i - 1].gears[1] != gear[i].gears[6]) {
                    direction *= -1
                    gear[i].move(direction)
                } else {
                    rf = true
                }
            }
        }


        var lf = false
        for (i in number - 2 downTo 0) {
            if (lf) {
                break
            }

            if (direction2 == 1) {
                if (gear[i].gears[2] != gear[i + 1].gears[7]) {
                    direction2 *= -1
                    gear[i].move(direction2)
                } else {
                    lf = true
                }
            } else {
                if (gear[i].gears[2] != gear[i + 1].gears[5]) {
                    direction2 *= -1
                    gear[i].move(direction2)
                } else {
                    lf = true
                }
            }
        }
    }


    var ans = 0
    for(i in 0..3){
        ans += gear[i].gears[0] * Math.pow(2.toDouble(), i.toDouble()).toInt()
    }

    println(ans)
}