import java.lang.StringBuilder

class KakaoSong {
    fun solution(m: String, musicinfos: Array<String>): String {
        var d = ""
        var ans = "(None)"
        var pre = 0

        for(i in m.indices){
            if(m[i] == '#'){
                continue
            }

            if(i != m.length - 1 && m[i + 1] == '#'){
                d += m[i].lowercase()
            }else{
                d += m[i]
            }
        }

        for (i in musicinfos.indices) {
            val list = musicinfos[i].split(",")

            val s = list[0].split(":").map { it.toInt() }
            val e = list[1].split(":").map { it.toInt() }
            val start = s[0] * 60 + s[1]
            val end = e[0] * 60 + e[1]

            val total = end - start
            val str = list[2]
            val song = list[3]

            if(check(song, d, total) && pre < total){
                pre = total
                ans = str
            }

        }

        return ans
    }

    fun check(song: String, d: String, time: Int): Boolean{
        var i = 0
        var str = ""
        var cnt = 0
        var s = ""

        for(j in song.indices){
            if(song[j] == '#'){
                continue
            }
            if(j != song.length - 1 && song[j + 1] == '#'){
                s += song[j].lowercaseChar()
            }else{
                s += song[j]
            }
        }

        val size = s.length
        while(cnt != time){
            str += s[i]
            if(d in str){
                return true
            }

            cnt++
            i = (i + 1) % size
        }

        return false
    }
}

fun main(){
    val ks = KakaoSong()
    println(ks.solution("ABCDEFG", arrayOf("12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF")))
    println(ks.solution("CC#BCC#BCC#BCC#B", arrayOf("03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B")))
    println(ks.solution("ABC", arrayOf("12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF")))

}