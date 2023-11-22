import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var N = 0
private var M = 0
private var min = Int.MAX_VALUE

private data class tQ(var num: Int, var position: Int, var x: Int, var y: Int)

private var positionList = mutableListOf<tQ>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    var map = Array(N) { Array(M) { 0 } }

    repeat(N) { idx ->
        val st = StringTokenizer(readLine())

        for (i in 0 until m) {
            val num = st.nextToken().toInt()
            if (num != 0 && num != 6) {
                positionList.add(tQ(num, 1, idx, i))
                map[idx][i] = num
            }
            if (num == 6) map[idx][i] = 6
        }
    }

    back(map, 0)

    println(min)

}

private fun back(tmap: Array<Array<Int>>, depth: Int) {
    if (depth == positionList.size) {
        var count = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (tmap[i][j] == 0)
                    count++
            }
        }
        min = minOf(min, count)
        return
    }
    var map = Array(N) { Array(M) { 0 } }

    for (i in 0 until N) {
        for (j in 0 until M) {
            map[i][j] = tmap[i][j]
        }
    }

    for (i in 1..4) {
        positionList[depth].position = i
        val (num, position, x, y) = positionList[depth]
        if (getPosition(num, position, map, x, y)) {
            back(map, depth + 1)
            bgetPosition(num, position, map, x, y)
        }

    }
}

private fun getPosition(num: Int, position: Int, map: Array<Array<Int>>, x: Int, y: Int): Boolean {
    if (num == 1) {
        if (position == 1) {
            s1(map, x, y)
            return true
        }
        if (position == 2) {
            s2(map, x, y)
            return true
        }
        if (position == 3) {
            s3(map, x, y)
            return true
        }
        if (position == 4) {
            s4(map, x, y)
            return true
        }

    } else if (num == 2) {
        if (position == 1) {
            s5(map, x, y)
            return true
        }
        if (position == 2) {
            s6(map, x, y)
            return true
        }

    } else if (num == 3) {
        if (position == 1) {
            s7(map, x, y)
            return true
        }
        if (position == 2) {
            s8(map, x, y)
            return true
        }
        if (position == 3) {
            s9(map, x, y)
            return true
        }
        if (position == 4) {
            s10(map, x, y)
            return true
        }

    } else if (num == 4) {
        if (position == 1) {
            s11(map, x, y)
            return true
        }
        if (position == 2) {
            s12(map, x, y)
            return true
        }
        if (position == 3) {
            s13(map, x, y)
            return true
        }
        if (position == 4) {
            s14(map, x, y)
            return true
        }

    } else if (num == 5) {
        if (position == 1) {
            s15(map, x, y)
            return true
        }
    }
    return false
}

private fun bgetPosition(num: Int, position: Int, map: Array<Array<Int>>, x: Int, y: Int) {
    if (num == 1) {
        if (position == 1) {
            bs1(map, x, y)
        }
        if (position == 2) {
            bs2(map, x, y)
        }
        if (position == 3) {
            bs3(map, x, y)
        }
        if (position == 4) {
            bs4(map, x, y)
        }

    } else if (num == 2) {
        if (position == 1) {
            bs5(map, x, y)
        }
        if (position == 2) {
            bs6(map, x, y)
        }

    } else if (num == 3) {
        if (position == 1) {
            bs7(map, x, y)
        }
        if (position == 2) {
            bs8(map, x, y)
        }
        if (position == 3) {
            bs9(map, x, y)
        }
        if (position == 4) {
            bs10(map, x, y)
        }

    } else if (num == 4) {
        if (position == 1) {
            bs11(map, x, y)
        }
        if (position == 2) {
            b12(map, x, y)
        }
        if (position == 3) {
            bs13(map, x, y)
        }
        if (position == 4) {
            bs14(map, x, y)
        }

    } else if (num == 5) {
        if (position == 1) {
            bs15(map, x, y)
        }
    }

    for(i in 0 until positionList.size){
        val x1 = positionList[i].x
        val y1 = positionList[i].y

        map[x1][y1] = positionList[i].num
    }
}


//오른쪽만
private fun s1(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in y + 1 until M) {
        if (map[x][i] == 6) {
            return
        }
        map[x][i] = 9
    }
}

private fun bs1(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in y + 1 until M) {
        if (map[x][i] == 6) {
            return
        }
        map[x][i] = 0
    }
}

// 왼쪽만
private fun s2(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in y - 1 downTo 0) {
        if (map[x][i] == 6) {
            return
        }
        map[x][i] = 9
    }
}

private fun bs2(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in y - 1 downTo 0) {
        if (map[x][i] == 6) {
            return
        }
        map[x][i] = 0
    }
}

//위쩍민
private fun s3(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in x - 1 downTo 0) {
        if (map[i][y] == 6) {
            return
        }
        map[i][y] = 9
    }
}

private fun bs3(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in x - 1 downTo 0) {
        if (map[i][y] == 6) {
            return
        }
        map[i][y] = 0
    }
}

//아래만
private fun s4(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in x + 1 until N) {
        if (map[i][y] == 6) {
            return
        }
        map[i][y] = 9
    }
}

private fun bs4(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in x + 1 until N) {
        if (map[i][y] == 6) {
            return
        }
        map[i][y] = 0
    }
}

//왼쪽, 오른쪽
private fun s5(map: Array<Array<Int>>, x: Int, y: Int) {
    s1(map, x, y)
    s2(map, x, y)
}

private fun bs5(map: Array<Array<Int>>, x: Int, y: Int) {
    bs1(map, x, y)
    bs2(map, x, y)
}

//위, 아래
private fun s6(map: Array<Array<Int>>, x: Int, y: Int) {
    s3(map, x, y)
    s4(map, x, y)
}

private fun bs6(map: Array<Array<Int>>, x: Int, y: Int) {
    bs3(map, x, y)
    bs4(map, x, y)
}

//위, 오른
private fun s7(map: Array<Array<Int>>, x: Int, y: Int) {
    s3(map, x, y)
    s1(map, x, y)
}

private fun bs7(map: Array<Array<Int>>, x: Int, y: Int) {
    bs3(map, x, y)
    bs1(map, x, y)
}

//오른 아래
private fun s8(map: Array<Array<Int>>, x: Int, y: Int) {
    s1(map, x, y)
    s4(map, x, y)
}

private fun bs8(map: Array<Array<Int>>, x: Int, y: Int) {
    bs1(map, x, y)
    bs4(map, x, y)
}

//왼쪽, 아래
private fun s9(map: Array<Array<Int>>, x: Int, y: Int) {
    s2(map, x, y)
    s4(map, x, y)
}

private fun bs9(map: Array<Array<Int>>, x: Int, y: Int) {
    bs2(map, x, y)
    bs4(map, x, y)
}

//위, 왼쪽
private fun s10(map: Array<Array<Int>>, x: Int, y: Int) {
    s2(map, x, y)
    s3(map, x, y)
}

private fun bs10(map: Array<Array<Int>>, x: Int, y: Int) {
    bs2(map, x, y)
    bs3(map, x, y)
}

//왼, 위, 오른
private fun s11(map: Array<Array<Int>>, x: Int, y: Int) {
    s2(map, x, y)
    s3(map, x, y)
    s1(map, x, y)
}

private fun bs11(map: Array<Array<Int>>, x: Int, y: Int) {
    bs2(map, x, y)
    bs3(map, x, y)
    bs1(map, x, y)
}

//위, 오른, 아래
private fun s12(map: Array<Array<Int>>, x: Int, y: Int) {
    s3(map, x, y)
    s1(map, x, y)
    s4(map, x, y)
}

private fun b12(map: Array<Array<Int>>, x: Int, y: Int) {
    bs3(map, x, y)
    bs1(map, x, y)
    bs4(map, x, y)
}

//왼, 아래, 오른
private fun s13(map: Array<Array<Int>>, x: Int, y: Int) {
    s3(map, x, y)
    s4(map, x, y)
    s1(map, x, y)
}

private fun bs13(map: Array<Array<Int>>, x: Int, y: Int) {
    bs3(map, x, y)
    bs4(map, x, y)
    bs1(map, x, y)
}

//위, 왼, 아래
private fun s14(map: Array<Array<Int>>, x: Int, y: Int) {
    s3(map, x, y)
    s2(map, x, y)
    s4(map, x, y)
}

private fun bs14(map: Array<Array<Int>>, x: Int, y: Int) {
    bs3(map, x, y)
    bs2(map, x, y)
    bs4(map, x, y)
}

private fun s15(map: Array<Array<Int>>, x: Int, y: Int) {
    s1(map, x, y)
    s2(map, x, y)
    s3(map, x, y)
    s4(map, x, y)
}

private fun bs15(map: Array<Array<Int>>, x: Int, y: Int) {
    bs1(map, x, y)
    bs2(map, x, y)
    bs3(map, x, y)
    bs4(map, x, y)
}