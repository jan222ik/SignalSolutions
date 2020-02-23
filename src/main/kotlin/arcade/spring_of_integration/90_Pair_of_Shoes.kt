package arcade.spring_of_integration

fun pairOfShoes(shoes: MutableList<MutableList<Int>>): Boolean {
    val map = hashMapOf<Int, Int>()
    shoes.forEach {
        map.compute(it[1]) { _: Int, u: Int? ->
            val di = if (it[0] == 0) -1 else 1
            return@compute if (u != null) u + di else di
        }
    }
    return map.values.firstOrNull { it != 0 } == null
}

fun main() {
    val expected = true
    val input = mutableListOf(
        mutableListOf(0, 21),
        mutableListOf(1, 23),
        mutableListOf(1, 21),
        mutableListOf(0, 23)
    )

    val real = pairOfShoes(input)
    assert(real == expected)
}
