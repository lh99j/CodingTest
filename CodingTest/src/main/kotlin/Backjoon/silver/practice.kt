import java.io.*
import java.lang.StringBuilder

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var count = br.readLine().toInt()
    var sb = StringBuilder()

    for (i in 0 until count) {
        var (h, w, n) = br.readLine().split(" ").map { it.toInt() }

        var a = n / h
        var b = n % h

        var str = ""

        if(b == 0){
            if(a < 10){
                str = "0$a"
            }else{
                str = "$a"
            }
        }else{
            if((a + 1) < 10){
                str = "0${a + 1}"
            }else{
                str = "${a + 1}"
            }
        }

        if(b == 0){
            b = h
        }

        if(h == 1){
            b = 1
            if(n < 10){
                str = "0$n"
            }else{
                str = "$n"
            }
        }

        sb.append("$b$str\n")
    }

    println(sb)
}