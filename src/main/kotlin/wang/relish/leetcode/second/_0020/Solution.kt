package wang.relish.leetcode.second._0020

import java.util.Stack


class Solution {
    fun isValid(s: String): Boolean {
        val st = Stack<Char>()
        for (i in 0 until s.length) {
            if (s[i] in arrayOf('{', '[', '(')) {
                st.push(s[i])
            } else {
                if (st.isEmpty()) {
                    return false
                }
                when (s[i]) {
                    '}' -> {
                        if (st.pop() != '{') {
                            return false
                        }
                    }

                    ']' -> {
                        if (st.pop() != '[') {
                            return false
                        }
                    }

                    ')' -> {
                        if (st.pop() != '(') {
                            return false
                        }
                    }
                }
            }
        }
        return st.isEmpty()
    }
}