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

fun char2d(raw: String): Array<CharArray> {
    val arr = raw.substring(2, raw.length - 2).split(Regex("], *\\["))
    val n = arr.size
    return Array(n) { i ->
        val s = arr[i]
        if (s.isEmpty()) {
            charArrayOf()
        } else {
            s.split(Regex(", *")).map {
                it.replace("\"","")[0]
            }.toCharArray()
        }
    }
}

fun Array<CharArray>.printSquare() {
    for (i in indices) {
        for (j in 0 until this[i].size) {
            print(String.format("%3c ", this[i][j]))
        }
        println()
    }
    println()
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