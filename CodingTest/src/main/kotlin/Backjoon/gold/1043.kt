import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (peopleSize, partySize) = br.readLine().split(" ").map { it.toInt() }
    val truthPeoples = br.readLine().split(" ").map { it.toInt() }

    val truths = HashSet<Int>()
    var inputs: MutableList<List<Int>> = mutableListOf()

    // 진실을 아는 사람의 입력이 1보다 클 때만 진실 배열에 추가
    if (truthPeoples.size > 1) {
        for (i in 1 until truthPeoples.size) {
            truths.add(truthPeoples[i])
        }
    }

    // 입력을 담고 있는 배열 추가
    repeat(partySize) {
        val peoples = br.readLine().split(" ").map { it.toInt() }
        inputs.add(peoples)
    }

    var validIndex = HashSet<Int>()

    while (true) {
        var end = true

        if (inputs.isEmpty()) {
            break
        }

        for (i in 0 until inputs.size) {
            if (i !in validIndex) {
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
                    validIndex.add(i)
                    end = false
                    break
                }
            }
        }

        if (end) {
            break
        }

    }

    println(inputs.size - validIndex.size)
}