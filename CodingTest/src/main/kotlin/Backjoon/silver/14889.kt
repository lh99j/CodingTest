import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import java.util.*

private lateinit var sc: Array<Array<Int>>
private lateinit var teamVisited: Array<Boolean>
private var min = Int.MAX_VALUE

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    sc = Array(cnt){Array(cnt) { 0 } }

    for (i in 0 until cnt) {
        val token = StringTokenizer(br.readLine())
        for (j in 0 until cnt) {
            sc[i][j] = token.nextToken().toInt()
        }
    }

    teamVisited = Array(cnt) { false }

    divideTeam(0, 0)
    println(min)
}

private fun divideTeam(start: Int, depth: Int){
    if(sc.size / 2 == depth){
        var team1Value = 0
        var team2Value = 0

        for(i in sc.indices){
            for(j in sc.indices){
                if(teamVisited[i] && teamVisited[j])
                    team1Value += sc[i][j]
                else if(!teamVisited[i] && !teamVisited[j])
                    team2Value += sc[i][j]
            }
        }

        min = minOf(min, abs(team1Value - team2Value))

        return
    }

    for(i in start until sc.size){
        if(teamVisited[i])
            continue

        teamVisited[i] = true
        divideTeam(i, depth + 1)
        teamVisited[i] = false
    }
}