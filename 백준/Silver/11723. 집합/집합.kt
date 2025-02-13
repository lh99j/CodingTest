private val nums = mutableSetOf<Int>()
private val sb = StringBuilder()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = mutableListOf<Int>()

    repeat(n) {
        operation(br.readLine())
    }
    
    println(sb)
}

private fun operation(input: String) {
    val op = input.split(" ")

    when (op[0]) {
        "add" -> {
            val num = op[1].toInt()
            nums.add(num)
        }

        "remove" -> {
            val num = op[1].toInt()
            nums.remove(num)
        }

        "check" -> {
            val num = op[1].toInt()
            sb.append(if (nums.contains(num)) 1 else 0).append("\n")

        }

        "toggle" -> {
            val num = op[1].toInt()
            if (nums.contains(num)) {
                nums.remove(num)
            } else {
                nums.add(num)
            }
        }

        "all" -> {
            for(i in 1..20){
                nums.add(i)
            }
        }

        "empty" -> {
            nums.clear()
        }
    }
}