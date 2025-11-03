fun main() {
    val br = System.`in`.bufferedReader()
    val inputs = br.readLine().split(" ").map { it.toLong() }
    val w = inputs[0]
    val h = inputs[1]
    val f = inputs[2]
    val c = inputs[3]
    val x1 = inputs[4]
    val y1 = inputs[5]
    val x2 = inputs[6]
    val y2 = inputs[7]
    val wh = w * h
    val xw = if(w - f < f) {
        w - f
    } else f

    val answer = if (xw < x1) {
        (x2 - x1) * (y2 - y1) * (c + 1)
    } else if (xw >= x2) {
        (x2 - x1) * (y2 - y1) * (c + 1) * 2
    } else {
        (xw - x1) * (y2 - y1) * (c + 1) * 2 + (x2 - xw) * (y2 - y1) * (c + 1)
    }

    println(wh - answer)
}