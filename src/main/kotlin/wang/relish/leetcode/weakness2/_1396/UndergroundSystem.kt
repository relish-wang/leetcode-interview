package wang.relish.leetcode.weakness2._1396

class UndergroundSystem() {

    val checkIn = hashMapOf<Int, Pair<String, Int>>() // <乘客,<地铁站, 入站时间>>

    val total = hashMapOf<String, Pair<Int, Int>>() // <出站#入站, <总时长, 个数>>

    fun checkIn(id: Int, stationName: String, t: Int) {
        checkIn[id] = stationName to t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val pair = checkIn[id] ?: return
        val checkInStationName = pair.first
        val checkInTime = pair.second
        val key = "${checkInStationName}#$stationName"
        val pair2 = total[key]
        val totalTime = pair2?.first ?: 0
        val times = pair2?.second ?: 0
        total[key] = Pair(totalTime + t - checkInTime, times + 1)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return total["${startStation}#${endStation}"]?.let {
            it.first * 1.0 / it.second
        } ?: 0.0
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

fun main() {
    val undergroundSystem = UndergroundSystem()
    undergroundSystem.checkIn(45, "Leyton", 3)
    undergroundSystem.checkIn(32, "Paradise", 8)
    undergroundSystem.checkIn(27, "Leyton", 10)
    undergroundSystem.checkOut(45, "Waterloo", 15) // 乘客 45 "Leyton" -> "Waterloo" ，用时 15-3 = 12
    undergroundSystem.checkOut(27, "Waterloo", 20) // 乘客 27 "Leyton" -> "Waterloo" ，用时 20-10 = 10
    undergroundSystem.checkOut(32, "Cambridge", 22) // 乘客 32 "Paradise" -> "Cambridge" ，用时 22-8 = 14
    undergroundSystem.getAverageTime("Paradise", "Cambridge").also { println(it) } // 返回 14.00000 。只有一个 "Paradise" -> "Cambridge" 的行程，(14) / 1 = 14
    undergroundSystem.getAverageTime("Leyton", "Waterloo").also { println(it) } // 返回 11.00000 。有两个 "Leyton" -> "Waterloo" 的行程，(10 + 12) / 2 = 11
    undergroundSystem.checkIn(10, "Leyton", 24)
    undergroundSystem.getAverageTime("Leyton", "Waterloo").also { println(it) } // 返回 11.00000
    undergroundSystem.checkOut(10, "Waterloo", 38) // 乘客 10 "Leyton" -> "Waterloo" ，用时 38-24 = 14
    undergroundSystem.getAverageTime("Leyton", "Waterloo").also { println(it) } // 返回 12.00000 。有三个 "Leyton" -> "Waterloo" 的行程，(10 + 12 + 14) / 3 = 12
}