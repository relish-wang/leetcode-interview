package wang.relish.leetcode.first._215

import java.util.*

/**
 * from baidu百科
 */
object HeapSort {
    /**
     * 选择排序-堆排序
     * @param array 待排序数组
     * @return 已排序数组
     *     #
     *   4<
     *     #
     * 5<
     *     2
     *   3<
     *     1
     */
    fun heapSort(array: IntArray): IntArray {
        //这里元素的索引是从0开始的,所以最后一个非叶子结点array.length/2 - 1
        for (i in array.size / 2 - 1 downTo 0) {
            adjustHeap(array, i, array.size) //调整堆
        }
        println("建堆: " + Arrays.toString(array))
        // 上述逻辑，建堆结束
        // 下面，开始排序逻辑
        for (i in array.size - 1 downTo 1) {
            // 元素交换,作用是去掉大顶堆
            // 把大顶堆的根元素，放到数组的最后；换句话说，就是每一次的堆调整之后，都会有一个元素到达自己的最终位置
            print("交换arr[0](${array[0]})和arr[$i](${array[i]}): ")
            swap(array, 0, i)
            println(array.contentToString())
            // 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
            // 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因
            // 而这里，实质上是自上而下，自左向右进行调整的
            adjustHeap(array, 0, i)
            println("调整堆($i): " + array.contentToString())
            println()
        }
        return array
    }

    /**
     * 整个堆排序最关键的地方
     * @param array 待组堆
     * @param index 起始结点
     * @param length 堆的长度
     */
    fun adjustHeap(array: IntArray, index: Int, length: Int) {
        // 先把当前元素取出来，因为当前元素可能要一直移动
        var i = index
        val temp = array[i]
        var k = 2 * i + 1
        while (k < length) {
            //2*i+1为左子树i的左子树(因为i是从0开始的),2*k+1为k的左子树
            // 让k先指向子节点中最大的节点
            if (k + 1 < length && array[k] < array[k + 1]) {  //如果有右子树,并且右子树大于左子树
                k++
            }
            //如果发现结点(左右子结点)大于根结点，则进行值的交换
            if (array[k] > temp) {
                swap(array, i, k)
                // 如果子节点更换了，那么，以子节点为根的子树会受到影响,所以，循环对子节点所在的树继续进行判断
                i = k
            } else {  //不用交换，直接终止循环
                break
            }
            k = 2 * k + 1
        }
    }

    /**
     * 交换元素
     * @param arr
     * @param a 元素的下标
     * @param b 元素的下标
     */
    fun swap(arr: IntArray, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(4, 2, 5, 1, 3)
        println("数组: " + arr.contentToString() + "\n")
        heapSort(arr)
        println(arr.contentToString())
    }
}
