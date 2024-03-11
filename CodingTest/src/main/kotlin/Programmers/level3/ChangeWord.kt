import java.util.*

class ChangeWord {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        var w = Array<MutableList<Int>>(words.size + 1) { mutableListOf() }

        for (i in words.indices) {
            var firstWord = words[i]
            var cnt = 0

            for (k in 0 until words[i].length) {
                if (firstWord[k] != begin[k]) {
                    cnt++
                }
            }

            if (cnt == 1) {
                w[0].add(i + 1)
                w[i + 1].add(0)
            }

            for (j in i + 1 until words.size) {
                var changeCnt = 0
                var secondWord = words[j]

                for (k in 0 until words[i].length) {
                    if (firstWord[k] != secondWord[k]) {
                        changeCnt++
                    }
                }

                if (changeCnt == 1) {
                    w[i + 1].add(j + 1)
                    w[j + 1].add(i + 1)
                }
            }
        }

        return if (target !in words) {
            0
        } else {
            var idx = words.indexOf(target) + 1
            bfs(w, idx)
        }
    }

    private fun bfs(w: Array<MutableList<Int>>, target: Int): Int {
        val q: Queue<Int> = LinkedList()
        val visited = Array(w.size) { -1 }

        q.offer(0)
        visited[0] = 0

        while (q.isNotEmpty()) {
            val p = q.poll()

            if (p == target) {
                return visited[target]
            }

            w[p].forEach {
                if (visited[it] == -1) {
                    q.offer(it)
                    visited[it] = visited[p] + 1
                }
            }
        }

        return visited[target]
    }
}

fun main() {
    val cw = ChangeWord()
    println(cw.solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")))
}