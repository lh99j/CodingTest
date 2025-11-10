fun main() {
    val br = System.`in`.bufferedReader()
    var ans = 0
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(m) { CharArray(n) }
    val visited = Array(m * n) { BooleanArray(4) { false } } //위, 아, 왼, 오

    repeat(m) { i ->
        br.readLine().forEachIndexed { j, c ->
            map[i][j] = c
        }
    }

    for(i in 0 until m) {
        for(j in 0 until n) {
            if(map[i][j] == '.') continue

            //오른쪽 확인 (0, 1) - 아래의 오른쪽
            if(!visited[i * n + j][3] && j + 1 < n && map[i][j + 1] == '.' && i + 1 < m && map[i + 1][j] == 'X' && map[i + 1][j + 1] == '.') {
                ans++

                visited[i * n + j][3] = true
                visited[(i + 1) * n + j][3] = true
            }

            //아래 확인 (1, 0) - 오른쪽의 아래
            if(!visited[i * n + j][1] && i + 1 < m && map[i + 1][j] == '.' && j + 1 < n && map[i][j + 1] == 'X' && map[i + 1][j + 1] == '.') {
                ans++

                visited[i * n + j][1] = true
                visited[i * n + (j + 1)][1] = true
            }

            //왼쪽 확인 (0, -1) - 아래의 왼쪽
            if(!visited[i * n + j][2] && j - 1 >= 0 && map[i][j - 1] == '.' && i + 1 < m && map[i + 1][j] == 'X' && map[i + 1][j - 1] == '.'){
                ans++

                visited[i * n + j][2] = true
                visited[(i + 1) * n + j][2] = true
            }

            //위쪽 확인 (-1, 0) - 오른쪽의 위쪽
            if(!visited[i * n + j][0] && i - 1 >= 0 && map[i - 1][j] == '.' && j + 1 < n && map[i][j + 1] == 'X' && map[i -1][j + 1] == '.') {
                ans++

                visited[i * n + j][0] = true
                visited[i * n + (j + 1)][0] = true
            }
        }
    }


    println(ans)
}