import java.util.*
import kotlin.math.max

fun main() {
    println(
        merge(
            arrayOf(
                intArrayOf(15, 18),
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10)
            )
        ).toStr()
    )
    println(
        merge(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(4, 5)
            )
        ).toStr()
    )
    println(
        merge(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 3)
            )
        ).toStr()
    )
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    Arrays.sort(intervals) { o1, o2 ->
        val v1 = o1?.firstOrNull() ?: -1
        val v2 = o2?.firstOrNull() ?: -1
        return@sort if (v1 == v2) 0 else if (v1 > v2) 1 else -1
    }
    var i = 0
    val ans = mutableListOf<IntArray>()
    while (i < intervals.size) {
        val s = intervals[i][0]
        var e = intervals[i][1]
        if (i == intervals.size - 1) {
            ans.add(intervals[i])
            break
        }
        i++
        while (i < intervals.size && intervals[i][0] <= e) {
            e = max(intervals[i][1], e)
            i++
        }
        ans.add(intArrayOf(s, e))
    }
    return ans.toTypedArray()
}

