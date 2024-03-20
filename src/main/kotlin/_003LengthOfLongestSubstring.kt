fun main() {
//    println(lengthOfLongestSubstring("abcabcbb"))//3
//    println(lengthOfLongestSubstring("bbbbb"))//1
//    println(lengthOfLongestSubstring("pwwkew"))//3
//    println(lengthOfLongestSubstring("a"))//1
//    println(lengthOfLongestSubstring("au"))//2
//    println(lengthOfLongestSubstring("aab"))//2
//    println(lengthOfLongestSubstring("abcba"))//3
    println(lengthOfLongestSubstring("abbaabba"))

}

    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        val size = s.length
        val map = hashMapOf<Char, Int>()
        var start = 0 // 左指针(保证不会左跳, 保证start到i之间没有重复字符)
        for(i in 0 until size) {
            val c = s[i]
            if (map.containsKey(c)) { // 2 为true表示有重复字符(这个条件可能不一定会进入, 比如"abc")
                // 保证左指针不左跳
                // 比如"abba", 执行到i=3时, start=2, ch['a']+1 = 1。如果没有这个max, start就又变到1了。而"bba"里有重复字符, 再下一句执行就错了。
                val last = map[c]!! + 1
                if (last <= start) {
                    println("s[$i] = $c last = $last, start = $start")
                }
                start = Math.max(start, last)
                println("start = $start")
            }
            // 如果一直不出现重复字符, 那么start就一直是0; 要是出现了重复字符, start就是上个最长子串的头下标+1
            max = Math.max(max, i - start + 1)
            // 1 每次往map里塞字符和它对应的下标
            map[c] = i
        }
        return max
    }