import java.util.*

private val LEFT = charArrayOf('(', '[', '{');
private val RIGHT = charArrayOf(')', ']', '}');

fun isValid(str: String): Boolean {
    val stack = Stack<Char>()
    for (ch in str) {
        if (ch in LEFT) {
            stack.push(ch)
        } else {
            if (stack.isEmpty() || ch != RIGHT[LEFT.indexOf(stack.pop())]) {
                return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("()")) // true
    println(isValid("{[()]}")) // true
    println(isValid("(")) // false
    println(isValid("{(]}")) // false
}