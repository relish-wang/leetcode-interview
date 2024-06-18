package wang.relish.leetcode.daily._2288

import java.util.regex.Pattern

class Solution {

    // val reg = "([\\s|\\s]+|^)\\\$\\d+([\\s|\\s]+|$)"
    val reg = "\\$\\d+"

    fun discountPrices(sentence: String, discount: Int): String {
        if (sentence.contains(Regex(reg)).not()) return sentence
        val pattern = Pattern.compile(reg)
        val matcher = pattern.matcher(sentence)
        val sb = StringBuffer()
        while (matcher.find()) {
            val g = matcher.group()
            val start = matcher.start()
            val end = matcher.end()
            if ((start == 0 || sentence[start - 1] == ' ') && (end == sentence.length || sentence[end] == ' ')) {
                matcher.appendReplacement(sb, discount(g, discount))
            }
        }
        matcher.appendTail(sb)
        return sb.toString()
    }

    fun discount(group: String, discount: Int): String {
        val p = Pattern.compile("(\\d+)")
        val m = p.matcher(group)
        if (m.find()) {
            val n = m.group().toDouble()
            val replace = String.format("%.2f", n * (100.0 - discount) / 100.0)
            return m.replaceAll(replace).replace("$", "\\$")
        }
        return group
    }
}

fun main() {
    println(Solution().discountPrices("there are \$1 \$2 and 5\$ candies in the shop", 50))
    println(Solution().discountPrices("1 2 \$3 4 \$5 \$6 7 8\$ \$9 \$10\$", 100))
    println(Solution().discountPrices("ka3caz4837h6ada4 r1 \$602", 9)) // "ka3caz4837h6ada4 r1 $547.82"
    println(
        Solution().discountPrices(
            "\$2\$3 \$10 \$100 \$1 200 \$33 33\$ \$\$ \$99 \$99999 \$9999999999",
            0
        )
    ) // "ka3caz4837h6ada4 r1 $547.82"
}

