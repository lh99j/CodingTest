import java.io.BufferedReader
import java.io.InputStreamReader

private val romaNum = mapOf(
    "I" to 1,
    "V" to 5,
    "X" to 10,
    "L" to 50,
    "C" to 100,
    "D" to 500,
    "M" to 1000,
    "Q" to 4,
    "W" to 9,
    "E" to 40,
    "R" to 90,
    "T" to 400,
    "Y" to 900
)
private val cnt = mutableMapOf(
    "M" to 3,
    "D" to 1,
    "C" to 3,
    "L" to 1,
    "X" to 3,
    "V" to 1,
    "I" to 3,
    "IV" to 1,
    "IX" to 1,
    "XL" to 1,
    "XC" to 1,
    "CD" to 1,
    "CM" to 1
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val first = br.readLine().toInt()
    val second = br.readLine().toInt()
    val sb = StringBuilder()
    var sum = first + second
    sb.append(sum).append("\n")

    loop@ while (true) {
        if (sum >= 1000 && cnt["M"]!! > 0) {
            sum -= 1000
            cnt["M"] = cnt["M"]!! - 1
            sb.append("M")
            continue@loop
        }

        if (sum >= 900 && cnt["CM"]!! > 0) {
            sum -= 900
            cnt["CM"] = cnt["CM"]!! - 1
            sb.append("CM")
            continue@loop
        }

        if (sum >= 500 && cnt["D"]!! > 0) {
            sum -= 500
            cnt["D"] = cnt["D"]!! - 1
            sb.append("D")
            continue@loop
        }

        if (sum >= 400 && cnt["CD"]!! > 0) {
            sum -= 400
            cnt["CD"] = cnt["CD"]!! - 1
            sb.append("CD")
            continue@loop
        }

        if (sum >= 100 && cnt["C"]!! > 0) {
            sum -= 100
            cnt["C"] = cnt["C"]!! - 1
            sb.append("C")
            continue@loop
        }

        if (sum >= 90 && cnt["XC"]!! > 0) {
            sum -= 90
            cnt["XC"] = cnt["XC"]!! - 1
            sb.append("XC")
            continue@loop
        }

        if (sum >= 50 && cnt["L"]!! > 0) {
            sum -= 50
            cnt["L"] = cnt["L"]!! - 1
            sb.append("L")
            continue@loop
        }

        if (sum >= 40 && cnt["XL"]!! > 0) {
            sum -= 40
            cnt["XL"] = cnt["XL"]!! - 1
            sb.append("XL")
            continue@loop
        }

        if (sum >= 10 && cnt["X"]!! > 0) {
            sum -= 10
            cnt["X"] = cnt["X"]!! - 1
            sb.append("X")
            continue@loop
        }

        if (sum >= 9 && cnt["IX"]!! > 0) {
            sum -= 9
            cnt["IX"] = cnt["IX"]!! - 1
            sb.append("IX")
            continue@loop
        }

        if (sum >= 5 && cnt["V"]!! > 0) {
            sum -= 5
            cnt["V"] = cnt["V"]!! - 1
            sb.append("V")
            continue@loop
        }

        if (sum >= 4 && cnt["IV"]!! > 0) {
            sum -= 4
            cnt["IV"] = cnt["IV"]!! - 1
            sb.append("IV")
            continue@loop
        }

        if (sum >= 1 && cnt["I"]!! > 0) {
            sum -= 1
            cnt["I"] = cnt["I"]!! - 1
            sb.append("I")
            continue@loop
        }

        if (sum == 0) break@loop
    }

    println(sb.toString())
}

private fun String.toInt(): Int = this.replace().chunked(1).sumOf { romaNum[it]!! }
private fun String.replace() = this.replace("IV", "Q")
    .replace("IX", "W")
    .replace("XL", "E")
    .replace("XC", "R")
    .replace("CD", "T")
    .replace("CM", "Y")
