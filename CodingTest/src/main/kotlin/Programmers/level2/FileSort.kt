class FileSort {
    private data class File(val head: String, val number: String, val tail: String)
    fun solution(files: Array<String>): MutableList<String> {
        val file = mutableListOf<File>()

        for(i in files.indices){
            file.add(splitFile(files[i]))
        }

        file.sortWith(compareBy<File> { it.head.uppercase() }.thenBy { it.number.toInt() })

        var answer = mutableListOf<String>()

        for(temp in file){
            answer.add("${temp.head}${temp.number}${temp.tail}")
        }

        return answer
    }

    private fun splitFile(str: String): File{
        var i = 0
        var head = ""
        var number = ""
        var tail = ""

        while(true){
            if(str[i].code in 48..57){
                break
            }
            i++
        }

        head = str.substring(0, i)
        var endHead = i

        while(true){
            if(str[i].code !in 48..57){
                break
            }

            if(i == str.length - 1){
                i++
                break
            }

            i++
        }

        number = str.substring(endHead, i)

        if(i != str.length - 1){
            tail = str.substring(i, str.length)
        }

        println("head: $head, number : $number, tail: $tail")
        return File(head, number, tail)
    }
}

fun main(args: Array<String>){
    val fs = FileSort()
    println(fs.solution(arrayOf("img12", "img10", "img02", "img1", "IMG01", "img2")))
}
