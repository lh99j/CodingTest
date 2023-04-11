import java.io.*
import java.util.*
import kotlin.math.min

private const val MAX = 1_000_000
private lateinit var valueArr: Array<Array<Array<Int>>>
private data class Dot3(val x: Int, val y: Int, val z: Int)

private val dx = arrayOf(0, -1, 0, 1, 0, 0)
private val dy = arrayOf(1, 0, -1, 0, 0, 0)
private val dz = arrayOf(0, 0, 0, 0, 1, -1)
private var N = 0
private var M = 0
private var H = 0


fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (m, n, h) = br.readLine().split(" ").map { it.toInt() }
    var tomatoMap = Array(n){Array(m){Array(h){ 0 } } }
    valueArr = Array(n){Array(m){Array(h){ MAX } } }
    N = n
    M = m
    H = h

    //Arr 입력받기
    for(k in 0 until h){
        for(i in 0 until n){
            var readArr = br.readLine().split(" ").map { it.toInt() };
            for(j in 0 until readArr.size){
                tomatoMap[i][j][k] = readArr[j]
            }
        }
    }

    for (k in 0 until h) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                if(tomatoMap[i][j][k] == -1)
                    valueArr[i][j][k] = -1
            }
        }
    }

    var dotArray = mutableListOf<Dot3>()

    for (k in 0 until h) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                if(tomatoMap[i][j][k] == 1)
                    dotArray.add(Dot3(i, j, k))
            }
        }
    }

    bfs(tomatoMap, dotArray)

    if(!isContain(tomatoMap, 0)){
        println("0")
    }else if(isContain(valueArr, MAX)){
        println("-1")
    }else{
        println(getMaxValue(valueArr))
    }

}

private fun bfs(map: Array<Array<Array<Int>>>, dotArr: MutableList<Dot3>) {
    var q: Queue<Dot3> = LinkedList<Dot3>()
    var visited = Array(N){Array(M){Array(H){ 0 } } }

    dotArr.forEach {
        q.offer(Dot3(it.x, it.y, it.z))
        valueArr[it.x][it.y][it.z] = 0
        visited[it.x][it.y][it.z] = 1
    }

    while (q.isNotEmpty()) {
        var temp = q.poll()

        for (i in 0 until 6) {
            var nx = temp.x + dx[i]
            var ny = temp.y + dy[i]
            var nz = temp.z + dz[i]

            if (nx in 0 until N && ny in 0 until M && nz in 0 until H && map[nx][ny][nz] == 0 && visited[nx][ny][nz] != 1) {
                q.offer(Dot3(nx, ny, nz))
                visited[nx][ny][nz] = 1
                valueArr[nx][ny][nz] = min(valueArr[temp.x][temp.y][temp.z] + 1, valueArr[nx][ny][nz])
            }
        }

    }

    dotArr.forEach {
        valueArr[it.x][it.y][it.z] = -1
    }
}

private fun isContain(arr: Array<Array<Array<Int>>>, num: Int): Boolean{
    for(k in 0 until H){
        for(i in 0 until N){
            for(j in 0 until M){
                if(arr[i][j][k] == num)
                    return true
            }
        }
    }

    return false
}

private fun getMaxValue(arr: Array<Array<Array<Int>>>): Int{
    var max = 0
    for(k in 0 until H){
        for(i in 0 until N){
            for(j in 0 until M){
                if(arr[i][j][k] > max)
                    max = arr[i][j][k]
            }
        }
    }

    return max
}