import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

private data class tree16235(var x: Int, var y: Int, var z: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, K) = br.readLine().split(" ").map { it.toInt() }
    val foods = Array<MutableList<Int>>(N) { mutableListOf() }
    val land = Array(N) { Array(N) { 5 } }
    val dieTrees = mutableListOf<tree16235>()
    val trees: Deque<tree16235> = LinkedList()

    // 입력 N x N 배열 만들기
    // 해당 배열은 겨울에 양분 추가할 때 사용함
    repeat(N) { idx ->
        val input = br.readLine().split(" ").map { it.toInt() }
        foods[idx].addAll(input)
    }

    //구매한 M개의 나무 심기 map[x - 1][y - 1] = z
    repeat(M) {
        val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
        trees.offerLast(tree16235(x - 1, y - 1, z))
    }

    //로직 구현
    //봄 : 나이가 낮은 순의 나무순서대로 양분 먹고 나이가 1만큼 증가, 먹을 양분이 없다면 나무는 죽는다. 양분은 본인 위치에 있는 양분만 먹을 수 있다.
    //여름 : 죽은 나무가 양분이 된다. 양분의 값은 (죽은 나무의 나이 / 2)
    //가을 : 나이가 5의 배수인 나무는 번식을 하여 1x1의 인접 8칸에 나이가 1인 나무가 생성된다.
    //겨울 : 양분의 값이 (양분의 값 + 입력) 가 된다.
    repeat(K) {
        //봄
        for (i in 0 until trees.size) {
            val (x, y, z) = trees.pollFirst()
            if (land[x][y] >= z) {
                land[x][y] -= z
                trees.offerLast(tree16235(x, y, z + 1))
            } else {
                dieTrees.add(tree16235(x, y, z))
            }
        }

        //여름
        dieTrees.forEach {
            land[it.x][it.y] += it.z / 2
        }
        dieTrees.clear()

        //가을
        val t = mutableListOf<tree16235>()
        for (i in 0 until trees.size) {
            val (x, y, z) = trees.pollLast()

            if (z % 5 == 0) {
                for (j in 0..7) {
                    val nx = x + dx[j]
                    val ny = y + dy[j]

                    if (nx in 0 until N && ny in 0 until N) {
                        trees.offerFirst(tree16235(nx, ny, 1))
                    }
                }
            }
            t.add(tree16235(x, y, z))
        }

        for(i in t.size - 1 downTo 0){
            trees.offerLast(t[i])
        }

        //겨울
        for (i in 0 until N) {
            for (j in 0 until N) {
                land[i][j] += foods[i][j]
            }
        }
    }

    println(trees.size)
}