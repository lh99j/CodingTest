import java.util.*

class Network {

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        var visited = Array<Int>(n){ 0 }
        var q: Queue<Int> = LinkedList()

        for(i in 0 until n){
            if(visited[i] == 0){
                q.offer(i)
                visited[i] = 1
                answer++

                while(q.isNotEmpty()){
                    val node = q.poll()

                    for(j in 0 until n){
                        if(node == j)
                            continue

                        if(visited[j] == 0 && computers[node][j] == 1){
                            q.offer(j)
                            visited[j] = 1
                        }
                    }
                }
            }
        }

        return answer
    }
}

fun main() {
    val n = Network()
}