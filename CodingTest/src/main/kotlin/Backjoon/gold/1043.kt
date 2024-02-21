import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (peopleSize, partySize) = br.readLine().split(" ").map { it.toInt() }
    val truthPeoples = br.readLine().split(" ").map { it.toInt() }

    val truths = HashSet<Int>()
    val liers = HashSet<Int>()
    var inputs: MutableList<List<Int>> = mutableListOf()

    if (truthPeoples.size > 1) {
        for (i in 1 until truthPeoples.size) {
            truths.add(truthPeoples[i])
        }
    }


    repeat(partySize) {
        val peoples = br.readLine().split(" ").map { it.toInt() }
        inputs.add(peoples)
    }

    var validInputs = inputs.toMutableList()

    while (true) {
        var end = true

        if (inputs.isEmpty()) {
            break
        }

        for (i in 0 until inputs.size) {
            var knowTruth = false

            //만약 진실을 아는사람이 하나라도 있다면
            for (j in 1 until inputs[i].size) {
                if (inputs[i][j] in truths) {
                    knowTruth = true
                    break
                }
            }

            //진실을 아는사람이 파티에 있었다면
            if (knowTruth) {

                // 해당 파티에 온 사람들은 전부 진실 리스트에 추가
                for (j in 1 until inputs[i].size) {
                    truths.add(inputs[i][j])
                }

                //해당 파티에서는 진실을 말할 수 없다.
                validInputs.remove(inputs[i])
                end = false
                break
            }
        }

        inputs = validInputs.toMutableList()

        if (end) {
            break
        }

    }

    println(inputs.size)
}