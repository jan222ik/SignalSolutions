package arcade.spring_of_integration

fun arrayPreviousLess(items: MutableList<Int>): MutableList<Int> {
    val outList = mutableListOf(-1)
    for (i in 1 until items.size) {
        val current = items[i]
        for (j in i - 1 downTo  0) {
            if (items[j] < current) {
                outList.add(items[j])
                break
            }
            if (j == 0) {
                outList.add(-1)
            }
        }
    }
    return outList
}

/**
 * Add -ea as vm args for asserts to work
 */
fun main() {
    val expected = listOf(-1, 3, -1, 2, 4)
    val input = mutableListOf(3, 5, 2, 4, 5)

    val real = arrayPreviousLess(input)
    assert(real.size == expected.size)
    expected.forEachIndexed {index, i ->
        assert(i == real[index])
    }
}

