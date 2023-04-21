class quad {
    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        var n = arr[0].size


        return answer
    }

    private fun merge(list: Array<IntArray>, left: Int,  mid: Int, right: Int): Boolean{
        //1
        for(i in left until mid){
            for(j in left until mid){

            }
        }

        //2
        for(i in mid until right){
            for(j in left until mid){

            }
        }

        //3
        for(i in left until mid){
            for(j in mid until right){

            }
        }

        //4
        for(i in mid until right){
            for(j in mid until right){

            }
        }

        return true
    }

    private fun mergeAndCompression(list: Array<IntArray>, left: Int, right: Int){
        val mid = (left + right) / 2

        if(left < right && merge(list, left, mid, right)) {
            mergeAndCompression(list, left, mid)
            mergeAndCompression(list, mid + 1, right)
        }
    }
}

fun main(args:Array<String>){

}