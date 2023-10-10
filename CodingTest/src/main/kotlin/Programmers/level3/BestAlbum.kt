class BestAlbum {
    fun solution(genres: Array<String>, plays: IntArray): MutableList<Int> {
        var answer = intArrayOf()
        var album = mutableMapOf<String, Int>()
        var ana = mutableListOf<Int>()

        for(i in genres.indices){
            album[genres[i]] = album.getOrDefault(genres[i], 0) + plays[i]
        }

        var sortAlbum = album.toList().sortedByDescending { it.second }.toMap().toMutableMap()

        sortAlbum.onEachIndexed { index, entry ->
            var (genre, play) = entry.toString().split("=")
            var genreMap = mutableMapOf<Int, Int>()

            for(i in genres.indices){
                if(genre == genres[i]){
                    genreMap[i] = plays[i]
                }
            }

            var sortGenreMap = genreMap.toList().sortedByDescending { it.second }.toMap().toMutableMap()

            var cnt = 0

            sortGenreMap.onEachIndexed{ index, entry ->
                if(cnt < 2){
                    var (idx, value) = entry.toString().split("=")
                    ana.add(idx.toInt())
                    cnt++
                }
            }

        }


        return ana
    }
}

fun main(){
    val ba = BestAlbum()
}