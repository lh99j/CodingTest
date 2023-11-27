class SpeedCamera {
    fun solution(routes: Array<IntArray>): Int {
        val sortedRoutes = routes.sortedBy { it[1] }
        var cnt = 1
        var carmera = sortedRoutes[0][1]

        sortedRoutes.forEach { routes ->
            if(carmera !in routes[0]..routes[1]){
                carmera = routes[1]
                cnt++
            }
        }

        return cnt
    }
}