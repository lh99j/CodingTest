class CandidateKey {
    private var ans = 0
    private var candidate = mutableListOf<String>()
    private var make = mutableListOf<Int>()

    fun solution(relation: Array<Array<String>>): Int {
        var check = Array<MutableList<String>>(relation[0].size) { mutableListOf() }

        for (i in 0 until relation.size) {
            for (j in 0 until relation[0].size) {
                check[j].add(relation[i][j])
            }
        }

        for (i in 1..relation[0].size) {
            back(relation, i, 0)
            make.clear()
        }

        return ans
    }

    private fun back(r: Array<Array<String>>, d: Int, start: Int) {
        if (make.size == d) {
            var check = mutableListOf<String>()

            for (i in 0 until r.size) {
                var str = ""

                make.forEach {
                    str += r[i][it]
                }

                if (str !in check) {
                    check.add(str)
                } else {
                    return
                }
            }

            candidate.forEach {
                var list = it.map { it.toString().toInt() }.toMutableList()
                if (make.containsAll(list)) {
                    return
                }

                if (list.containsAll(make)) {
                    return
                }
            }

            candidate.add(make.joinToString(""))

            ans++
            return
        }

        for (i in start until r[0].size) {
            make.add(i)
            back(r, d, start + 1)
            make.removeLast()
        }
    }
}