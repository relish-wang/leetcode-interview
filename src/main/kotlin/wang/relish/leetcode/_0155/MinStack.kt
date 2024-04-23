import struct.ClassExecutor

/**
 * https://leetcode.cn/problems/min-stack/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 *
 * 题解简单得令人爆炸
 * 两个Stack, 其中一个存当前栈的最小值, 一起入栈, 一起出栈。getMin就minStack.peek()
 */
class MinStack() {

    fun push(`val`: Int) {
    }

    fun pop() {
    }

    fun top(): Int {
        return 0
    }

    fun getMin(): Int {
        return 0
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

fun main() {
    val executor = ClassExecutor()
    executor.parseCommand(
        arrayOf("MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"),
        ClassExecutor.parseArrayOfIntArray("[[],[-2],[0],[-3],[],[],[],[]]")
    ) // [null,null,null,null,-3,null,0,-2]
}