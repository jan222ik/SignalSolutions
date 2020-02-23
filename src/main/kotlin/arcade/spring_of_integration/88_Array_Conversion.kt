package arcade.spring_of_integration


/**
 * Very Slow.
 */
fun arrayConversion(inputArray: MutableList<Int>): Int {
    var list: MutableList<Int> = inputArray
    var pass = 0
    while (list.size > 1) {
        val workList = mutableListOf<Int>()
        pass++
        for (i in 0 until list.size step 2) {
            if (pass.rem(2) == 0) { //Even
                workList.add(list[i] * list[i + 1])
            } else { //Uneven
                workList.add(list[i] + list[i + 1])
            }
        }
        list = workList
    }
    return list[0]
}

fun main() {
    assert(arrayConversion(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8)) == 186)
}
