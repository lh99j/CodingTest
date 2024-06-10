import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private class Snake3190() {
    var x: Int = 0
    var y: Int = 0
    var d: Int = 1
    var body: Deque<Pair<Int, Int>> = LinkedList()

    init {
        body.offer(x to y)
    }

    fun move() {
        x += dx[d]
        y += dy[d]
    }

    fun isCrashToBody() = body.contains(x to y)

    fun isEat(board: Array<BooleanArray>) {
        body.offerFirst(x to y)
        if (board[x][y]) {
            board[x][y] = false
        } else {
            body.pollLast()
        }
    }

    fun rotation(order: String) {
        when (order) {
            "D" -> turnRight()
            "L" -> turnLeft()
        }
    }

    private fun turnLeft() {
        d = if (d - 1 < 0) 3 else --d
    }

    private fun turnRight() {
        d = if (d + 1 > 3) 0 else ++d
    }
}

private var size = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    size = br.readLine().toInt()
    val board = Array(size) { BooleanArray(size) { false } }

    repeat(br.readLine().toInt()) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() - 1 }
        board[x][y] = true
    }

    val q: Queue<Pair<Int, String>> = LinkedList()

    repeat(br.readLine().toInt()) {
        val (time, order) = br.readLine().split(" ")
        q.offer(time.toInt() to order)
    }

    var snake = Snake3190()
    var time = 0

    while (true) {
        if (q.isNotEmpty() && time == q.peek().first) {
            val p = q.poll()
            snake.rotation(p.second)
        }

        snake.move()
        if (!validPosition(snake.x, snake.y) || snake.isCrashToBody()) {
            break
        }
        snake.isEat(board)

        time++
    }

    println(++time)
}

private fun validPosition(x: Int, y: Int) = x in 0 until size && y in 0 until size