package struct

fun int2d(raw: String): Array<IntArray> {
    val arr = raw.substring(2, raw.length - 2).split(Regex("], *\\["))
    val n = arr.size
    return Array(n) { i ->
        val s = arr[i]
        if (s.isEmpty()) {
            intArrayOf()
        } else {
            s.split(Regex(", *")).map {
                it.trim().toInt()
            }.toIntArray()
        }
    }
}

fun Array<IntArray>.printSquare() {
    for (i in indices) {
        for (j in 0 until this[i].size) {
            print(String.format("%3d ", this[i][j]))
        }
        println()
    }
    println()
}

fun maxValue(a: Int, vararg x: Int): Int {
    var max = a
    for (i in x) {
        max = maxOf(max, i)
    }
    return max
}