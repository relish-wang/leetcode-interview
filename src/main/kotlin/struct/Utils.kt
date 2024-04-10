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