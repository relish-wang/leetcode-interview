import java.util.*

fun main() {
    println(isValid(")"))
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("([])"))
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (i in s.indices) {
        val c = s[i]
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c)
        } else if (c == ')') {
            if (stack.isEmpty() || stack.pop() != '(') {
                return false
            }
        } else if (c == ']') {
            if (stack.isEmpty() || stack.pop() != '[') {
                return false
            }
        } else if (c == '}') {
            if (stack.isEmpty() || stack.pop() != '{') {
                return false
            }
        }
    }
    return stack.size == 0
}
