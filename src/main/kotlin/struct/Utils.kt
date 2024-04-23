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

fun String.toIntArray(): IntArray {
    return this.replace(Regex("[\\[\\]]"), "")
        .split(Regex(", *"))
        .takeIf {
            it.isNotEmpty()
        }?.map {
            it.trim().toInt()
        }!!.toIntArray()
}

fun List<List<Int>>.toStr() {
    Array(this.size) { r -> IntArray(this[r].size) { this[r][it] } }.contentToString()
}

fun List<List<Int>>.print() {
    val c = this.size
    //println(Array<IntArray>(c) { IntArray(this[it].size) { y -> this[it][y] } }.contentToString())
    for (i in 0 until c) {
        for (j in 0 until this[i].size) {
            print("${this[i][j]} ")
        }
        println()
    }
}

// 以下是特殊字符拷贝用
/*
┌──────────┬─────┬────────┬─────────────────────┐
│          │胜诉率│判决件数 │胜诉件数              │
│          │（％）│        ├────┬──┬────┤
│          │     │        │合计  │胜诉│胜败互见│
├──┬──┼───┼────┼───┼──┼────┤
│民事│合计│20.53 │548     │112.5 │53  │119     │
│    ├──┼───┼────┼───┼──┼────┤
│诉讼│著作│33.04 │112     │37.0  │17  │40      │
│    ├──┼───┼────┼───┼──┼────┤
│    │专利│11.60 │332     │38.5  │16  │45      │
│    ├──┼───┼────┼───┼──┼────┤
│    │商标│36.36 │88      │32.0  │17  │30      │
│    ├──┼───┼────┼───┼──┼────┤
│    │其他│31.25 │16      │5.0   │3   │4       │
├──┴──┴───┴────┴───┴──┴────┤
│注：1．胜诉件数一胜诉＋胜败互见／2                  │
├──────────────────────────┤
│2.胜诉率＝胜诉件数／终结件数×100％                 │
└──────────────────────────┘

 */