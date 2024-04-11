package wang.relish.leetcode.second._020

import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (c == '{' || c == '(' || c == '[') stack.push(c)
            else {
                if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false
                    }
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false
                    }
                } else {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}