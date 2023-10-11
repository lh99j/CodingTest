class BestAlbum {
    fun solution(genres: Array<String>, plays: IntArray): MutableList<Int> {
        var answer = intArrayOf()
        var album = mutableMapOf<String, Int>()
        var ana = mutableListOf<Int>()

        for(i in genres.indices){
            album[genres[i]] = album.getOrDefault(genres[i], 0) + plays[i]
        }

        //앨범을 value값으로 내림차순 정렬
        var sortAlbum = album.toList().sortedByDescending { it.second }.toMap().toMutableMap()

        sortAlbum.onEachIndexed { index, entry ->
            var (genre, play) = entry.toString().split("=")
            var genreMap = mutableMapOf<Int, Int>()

            for(i in genres.indices){
                if(genre == genres[i]){
                    genreMap[i] = plays[i]
                }
            }

            //sortAlbum 즉, 가장 재생수가 많은 앨범부터 (원래 genres 배열의 인덱스값, 재생수)를 담아 재생수 기준으로 내림차순 정렬
            var sortGenreMap = genreMap.toList().sortedByDescending { it.second }.toMap().toMutableMap()

            var cnt = 0

            sortGenreMap.onEachIndexed{ index, entry ->
                if(cnt < 2){
                    var (idx, value) = entry.toString().split("=")
                    ana.add(idx.toInt())

                    //카운트를 넣어주어 2보다 작을때만 실행됨
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