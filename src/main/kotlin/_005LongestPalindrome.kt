import kotlin.math.max

fun main() {
    println(longestPalindrome("babad"))
    println(longestPalindrome("abcba"))
}


fun longestPalindrome(s: String): String {
    val n = s.length
    var start = 0
    var end = 0
    for (i in 0 until n) {
        val l1 = expand(s, i, i)// 奇数回文
        val l2 = expand(s, i, i + 1) // 偶数回文
        val len = max(l1, l2) // 本次i下标为中心的较长回文长度
        if (len > end - start) {
            start = i - (len - 1) / 2 // -1是为了减掉中心点的那个
            end = i + len / 2 // 包含右边界
        }
    }
    return s.substring(start, end + 1) // 包含的右边界需要+1
}

fun expand(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    // 双指针分别向左右两边拓展, 直到找到不回文的字符
    while (l > 0 && r < s.length - 1 && s[l] == s[r]) {
        l--
        r++
    }
    return r - l - 1 // 多执行了一次l--和r++, 所以需要相减后-1; 用do-while的话就是r-l+1
}