fun main() {
    // [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//    val a = arrayOf(
//        intArrayOf(5, 1, 9, 11),
//        intArrayOf(2, 4, 8, 10),
//        intArrayOf(13, 3, 6, 7),
//        intArrayOf(15, 14, 12, 16)
//    )

    val a = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    )
//    val a = arrayOf(
//        intArrayOf(1, 2, 3),
//        intArrayOf(4, 5, 6),
//        intArrayOf(7, 8, 9)
//    )
    println(a.toStr())
    rotate(a)
    println(a.toStr())
}


/**
 * 矩阵旋转90度(不允许新建矩阵)
 *  1 2 3      7 4 1
 *  4 5 6  ->  8 5 2
 *  7 8 9      9 6 3
 *
 *  00 01 02
 *  10 11 12
 *  20 21 22
 *
 *  00 01 02 03  30 20 10 00
 *  10 11 12 13  31 21 11 01
 *  20 21 22 23  32 22 12 02
 *  30 31 32 33  33 23 13 03
 *
 *  00 01 02 03 04  40 30 20 10 00
 *  10 11 12 13 14  41 31 21 11 01
 *  20 21 22 23 24  42 32 22 12 02
 *  30 31 32 33 34  43 33 23 13 03
 *  40 41 42 43 44  44 34 24 14 04
 */
fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    if (n <= 1) {
        return
    }
    val depth = n / 2 // 层数
    for (d/* 回字的第几层 */ in 0 until depth) {
        for (i in d until n - d - 1) { // 以边长为4的矩阵为例, 共2层。第0层,从0遍历到3(不包含); 第1层, 从1遍历到2(不包含)
            // 顺时针转90°。根据赋值顺序, 需要逆时针转
            val t = matrix[d][i]// matrix[n-1-i][i] // 先存着(左上角), 因为这个位置要被赋新值了
            matrix[d][i] = matrix[n - 1  - i][d].also {
//                println("${d}层${i}个 左上 = 左下 [${d}][${i}] = [${n - 1  - i}][${d}] = $it")
            } // 左上角 用 左下角的值
            matrix[n - 1 - i][d] = matrix[n - 1 - d][n - 1 - i].also {
//                println("${d}层${i}个 左下 = 右下 [${n - 1 - i}][${d}] = [${n - 1 - d}][${n - 1 - i}] = $it")
            }// 左下角的值 用 右下角的值
            matrix[n - 1 - d][n - 1 - i] = matrix[i][n - 1 - d].also {
//                println("${d}层${i}个 右下 = 右上 [${n - 1 - d}][${n - 1 - i}] = [${i}][${n - 1 - i}] = $it")
            }// 右下角的值 用 右上角的值
            matrix[i][n - 1 - d] = t.also {
//                println("${d}层${i}个 右上 = 左上 [${n - 1 - i}][${n - 1 - d}] = [${d}][${i}] = $it")
            }// 右上角的值 用 左上角的值
            println()
        }
    }
}

fun Array<IntArray>.toStr() {
    for (i in 0 until this.size) {
        for (j in 0 until this[i].size) {
            print(String.format("%3d ", this[i][j]))
        }
        println()
    }
    println()
}