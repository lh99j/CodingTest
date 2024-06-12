import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
private val range = 0..3
private var max = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val fishes = Array(17) { Triple(0, 0, 0) } // x, y, direction
    val map = Array(4) { Array(4) { Pair(0, 0) } } //value to direction

    repeat(4) { x ->
        val st = StringTokenizer(br.readLine())

        repeat(4) { y ->
            var value = st.nextToken().toInt()
            var d = st.nextToken().toInt() - 1

            fishes[value] = Triple(x, y, d)
            map[x][y] = value to d
        }
    }



    var (x, y, d) = Triple(0, 0, map[0][0].second)
    val eat = map[0][0].first
    fishes[map[0][0].first] = Triple(-1, -1, -1)
    map[0][0] = 0 to 0

    fishMove(0 to 0, map, fishes)

    while (true) {
        x += dx[d]
        y += dy[d]

        if(!validPosition(x, y))
            break

        back(Triple(x, y, d), map, fishes, eat)
    }


    println(max)
}

private fun fishMove(shark: Pair<Int, Int>, map: Array<Array<Pair<Int, Int>>>, fishes: Array<Triple<Int, Int, Int>>) {
    for (i in 1..16) {
        if (fishes[i].first == -1)
            continue
        var (x, y, d) = fishes[i]
        var changable = false
        var nx = x + dx[d]
        var ny = y + dy[d]

        for (j in 0..7) {
            if (validPosition(nx, ny) && nx to ny != shark) {
                changable = true
                break
            }
            d = rotation(d)
            nx = x + dx[d]
            ny = y + dy[d]
        }

        if (changable) {
            map[x][y] = map[x][y].first to d
            fishes[map[x][y].first] = Triple(x, y, d)
            swap(x to y, nx to ny, map, fishes)
        }
    }
}

private fun rotation(d: Int) = if (d + 1 > 7) 0 else d + 1
private fun validPosition(x: Int, y: Int) = x in range && y in range
private fun swap(
    a: Pair<Int, Int>,
    b: Pair<Int, Int>,
    map: Array<Array<Pair<Int, Int>>>,
    fishes: Array<Triple<Int, Int, Int>>
) {
    val (x, y) = a //current
    val (nx, ny) = b // next

    fishes[map[x][y].first] = Triple(nx, ny, map[x][y].second)
    fishes[map[nx][ny].first] = Triple(x, y, map[nx][ny].second)

    val temp = map[nx][ny]
    map[nx][ny] = map[x][y]
    map[x][y] = temp
}

private fun back(
    shark: Triple<Int, Int, Int>,
    originMap: Array<Array<Pair<Int, Int>>>,
    originFishes: Array<Triple<Int, Int, Int>>,
    eat: Int
) {
    var (x, y, d) = shark
    if (!validPosition(x, y)) {
        max = maxOf(max, eat)
        return
    }

    val map = copyMap(originMap)
    val fishes = originFishes.copyOf()

    fishes[map[x][y].first] = Triple(-1, -1, -1)
    d = map[x][y].second
    var value = eat + map[x][y].first
    map[x][y] = 0 to 0

    fishMove(x to y, map, fishes)

    while (true) {
        x += dx[d]
        y += dy[d]

        if (validPosition(x, y) && map[x][y].first == 0) {
            continue
        }

        back(Triple(x, y, d), map, fishes, value)
        if (!validPosition(x, y))
            break
    }
}

private fun copyMap(map: Array<Array<Pair<Int, Int>>>) = Array(map.size) { idx -> map[idx].copyOf() }