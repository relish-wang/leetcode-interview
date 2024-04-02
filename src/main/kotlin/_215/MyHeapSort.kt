package _215

class MyHeapSort {
    fun sort(arr: IntArray) {
        mkHeap(arr)
        for (i in arr.size - 1 downTo 0) {
            swap(arr, 0, i)
            heapSort(arr, 0, i)
        }
    }

    fun mkHeap(arr: IntArray) {
        val n = arr.size
        var i = n / 2
        while (i >= 0) {
            heapSort(arr, i, n)
            i--
        }
    }

    /**
     * @param i 父节点(这个位置将成为【根】【左】【右】中的最大数)
     * @param len 堆大小
     */
    fun heapSort(arr: IntArray, i: Int, len: Int) {
        val l = i * 2 + 1// 左孩子
        var biggestIndex = i
        if (l < len && arr[l] > arr[biggestIndex]) {
            biggestIndex = l
        }
        if (l + 1 < len && arr[l + 1] > arr[biggestIndex]) {
            biggestIndex = l + 1
        }
        if (i != biggestIndex) {
            swap(arr, i, biggestIndex)
            heapSort(arr, biggestIndex, len) // 被交换的那一边的子树也进行堆排序
        }
    }

    fun swap(arr: IntArray, i: Int, j: Int) {
        val t = arr[i]
        arr[i] = arr[j]
        arr[j] = t
    }
}

fun main() {
    val arr = intArrayOf(5, 2, 4, 1, 3)
    println(arr.contentToString())
    MyHeapSort().sort(arr)
    println(arr.contentToString())
}