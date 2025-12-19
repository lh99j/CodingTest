fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    val inputs = br.readLine().split(" ").map { it.toLong() }.sorted()
    var ans = 0

    for(i in 0 until inputs.size) {
        var s = if(i == 0 && inputs.size > 1) 1 else 0
        var e = inputs.size - 1

        while(s < e) {
            if(e == i) {
                e--
                continue
            }

            if(s == i) {
                s ++
                continue
            }
            val sum = inputs[s] + inputs[e]
            if(sum == inputs[i]) {
                ans++
                break
            }

            if(sum < inputs[i]) {
                s++
            } else{
                e--
            }
        }
    }

    println(ans)
}
