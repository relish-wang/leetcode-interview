| 题目               | 标题                    | 难度 |           时间            | 备注                                                                         |
|:-----------------|:----------------------|:---|:-----------------------:|:---------------------------------------------------------------------------|
| [0001][0001]     | 两数之和                  | 简单 |          3:43           | hash表                                                                      |
| [0002][0002]     | 两数相加                  | 中等 |          8:10           |                                                                            |
| [0003][0003]     | 无重复字符的最长子串            | 中等 |          8:16           | ⚠️ 滑动窗口, 边界处理                                                              |
| [0005][0005]     | 最长回文子串                | 中等 |          10:06          | ⚠️    expand法, 其他方法不太会                                                     |
| [0011][0011]     | 盛最多水的容器               | 中等 |          4:37           | 双指针                                                                        |
| [0015][0015]     | 三数之和                  | 中等 |          13:14          | ⚠️  需深度理解                                                                  |
| [0019][0019]     | 删除链表的倒数第 N 个结点        | 中等 |          3:26           | 快慢指针                                                                       |
| [0020][0020]     | 有效的括号                 | 简单 |          3:35           | Stack                                                                      |
| [0021][0021]     | 合并两个有序链表              | 简单 |          3:56           | 快的, 进阶[0148][0148]                                                         |
| [0022][0022]     | 括号生成                  | 中等 |          4:26           | ⚠️ 理解一下dfs、回溯,再做一遍。                                                        |
| [0033][0033]     | 搜索旋转排序数组              | 中等 |          12:04          | ⚠️ 二分法、考虑是否递增, 还要再加快                                                       |
| [0034][0034]     | 在排序数组中查找元素的第一个和最后一个位置 | 中等 |          7:14           | 跟上一题差不多                                                                    |
| [0039][0039]     | 组合总和                  | 中等 |        ~~16:26~~        | ⚠️ 回溯,剪枝 弱项                                                                |
| [0042][0042]     | 接雨水                   | 困难 |          04:20          | 经典字节面试题, 左右最高数组, 取较小值, 减去当前值,秒了                                            |
| [0048][0048]     | 旋转图像                  | 中等 |          7:03           | 有机会再练练                                                                     |
| [0049][0049]     | 字母异位词分组               | 中等 |          1:06           | 哈希 groupby秒了                                                               |
| [0053][0053]     | 最大子数组和                | 中等 |          1:08           | dp️                                                                        |
| [0055][0055]     | 跳跃游戏                  | 中等 |          5:00           |                                                                            |
| [0056][0056]     | 合并区间                  | 中等 |          7:26           | 排序怎么排                                                                      |
| [0062][0062]     | 不同路径                  | 中等 |          6:33           | 可优化,再说                                                                     |
| [0064][0064]     | 最小路径和                 | 中等 |          4:29           | 和上一题很像                                                                     |
| [0070][0070]     | 爬楼梯                   | 简单 |          3:11           | 斐波那契                                                                       |
| [0072][0072]     | 编辑距离                  | 中等 |          4:00           | ⚠️还是要练。经典二维数组动态规划。@see [0712][0712]、[1143][1143] 建议三道一起刷                   |
| [0075][0075]     | 颜色分类                  | 中等 |           ⚠️            | 计数法没问题, 双指针要练(p0、p1, else if)                                              |
| [0078][0078]     | 子集                    | 中等 |          8:33           | 用dfs递归做出来了,也可以用二进制做                                                        |
| [0074][0094]     | 二叉树的中序遍历              | 简单 |          3:47           |                                                                            |
| [0096][0096]     | 不同的二叉搜索树              | 中等 |          4:00           | ⚠️ 卡特兰数记不住啊, 动态规划                                                          |
| [0098][0098]     | 验证二叉搜索树               | 中等 |          2:00           | 前序和中序可以在2分钟内解出来, 后序遍历解法全靠死记硬背(4分钟), 层序遍历没尝试                                |
| [0101][0101]     | 对称二叉树                 | 简单 |          2:25           | 秒了                                                                         |
| [0102][0102]     | 二叉树的层序遍历              | 中等 |          2:51           | 秒了                                                                         |
| [0103][0103]     | 二叉树的锯齿形层序遍历           | 中等 |          9:04           | 秒了, addFirst/removeFirst/addLast/removeLast                                |
| [0104][0104]     | 二叉树的最大深度              | 简单 |          0:51           | 递归秒了                                                                       |
| [0105][0105]     | 从前序与中序遍历序列构造二叉树       | 中等 |          17:35          | ⚠️ 边界注意                                                                    |
| [0106][0106]     | 从中序与后序遍历序列构造二叉树       | 中等 |          7:24           | 刷完上面那题秒了                                                                   |
| [0109][0109]     | 有序链表转换二叉搜索树           | 中等 |          16:59          | ⚠️~~自己摸索出来的从中间断开建树的方式~~。正统做法就是这个。但是我想得有点慢                                  |
| [0111][0111]     | 二叉树的最小深度              | 简单 |          7:07           | 层序遍历，秒了                                                                    |
| [0114][0114]     | 二叉树展开为链表              | 中等 |          8:44           | 递归秒了                                                                       |
| [0121][0121]     | 买卖股票的最佳时机             | 简单 |          10:31          | 简单题理解错了, 只能交易一次                                                            |
| [0122][0122]     | 买卖股票的最佳时机II           | 中等 |          8:06           | 理解好边界问题, 秒了                                                                |
| [0124][0124]     | 二叉树中的最大路径和            | 困难 |          1:41           | 考虑清楚什么时候取较大值, 还有点模糊。建议先刷[0543][0543]                                       |
| [0128][0128]     | 最长连续序列                | 中等 |           ⚠️            | set.contains(num-1)                                                        |
| [0129][0129]     | 求根节点到叶节点数字之和          | 中等 |          5:20           | 队列秒了                                                                       |
| [0136][0136]     | 只出现一次的数字              | 简单 |          00:53          | 异或秒了                                                                       |
| [0141][0141]     | 环形链表                  | 简单 |          2:29           | 快慢指针秒了                                                                     |
| [0142][0142]     | 环形链表II                | 中等 |          10:33          | 快慢指针相遇后, 再走一个慢指针2, 当慢指针1和慢指针2相遇, 则是环入口 @see [0287][0287]                   |
| [0146][0146]     | LRU 缓存                | 中等 |          08:53          | LinkedHashMap能秒, 但你必须会写双向链表(一遍过都需要8分多钟)                                    |
| [0148][0148]     | 排序链表                  | 中等 |        ⚠️ 14:08         | ~~归并还是递归好理解。~~ 还得用归并, 题目要求O(1)空间复杂度 复习一下[0021][0021]                       |
| [0152][0152]     | 乘积最大子数组               | 中等 |          07:14          | 因为负数的存在需要min和max两个dp数组, dp\[i]表示以nums\[i]结尾的连续数组的最大/小乘积值                   |
| [0155][0155]     | 最小栈                   | 中等 |          05:51          | 不用辅助栈, 单链表秒了, 每个node多存一个当前最小值                                              |
| [0160][0160]     | 相交链表                  | 简单 |          00:55          | a尾接b,b尾接a秒了                                                                |
| [0169][0169]     | 多数元素                  | 简单 |          01:28          | 投票算法, 消除数组中两个不同的数, 数组中的多数数还是不变                                             |
| [0189][0189]     | 打家劫舍                  | 中等 |          01:48          | 经典dp, 注意初始边界需要两个值 @see [0213][0213]、[0337][0337]、[2560][2560]              |
| [0200][0200]     | 岛屿数量                  | 中等 |          04:05          | dfs秒了                                                                      |
| [0206][0206]     | 反转链表                  | 简单 |    04:36 <br> 11:47     | 迭代秒了<br>递归秒了                                                               |
| [0209][0209]     | 长度最小的子数组              | 中等 |          14:31          | 滑动窗口秒了                                                                     |
| [0213][0213]     | 打家劫舍II                | 中等 |          15:29          | 房屋是个环, 双dp  @see[0189][0189]、[0337][0337]、[2560][2560]                     |
| [0215][0215]     | 数组中的第k个最大元素           | 中等 |           ⚠️            | 堆排序(❌, 先从使用PriorityQueue开始理解)、快排(❌)、桶排序(✅)                                 |
| [0225][0225]     | 用队列实现栈                | 简单 |          00:58          | 秒了(只能用队列的offer、poll、peek、isEmpty)                                          |
| [0226][0226]     | 翻转二叉树                 | 简单 |          00:50          | 递归秒了                                                                       |
| [0234][0234]     | 回文链表                  | 简单 |          06:16          | O(1)空间, 还得再练                                                               |
| [0236][0236]     | 二叉树的最近公共祖先            | 中等 |          15:53          | 自己写出来了                                                                     |
| [0238][0238]     | 除自身以外数组的乘积            | 中等 |          12:01          | 不允许用除法, 可以考虑双指针(前缀和*后缀和的做法) 类似题目@see [0042][0042]                          |
| [0283][0283]     | 移动零                   | 简单 | 01:44<br>06:49<br>05:00 | 正统解法双指针<br>数0的数量, 后面添0<br>冒泡排序也能过, 耗时较长                                    |
| [0287][0287]     | 寻找重复数                 | 中等 |          01:52          | 链表找环入口问题 @see [0142][0142]                                                 |
| [0297][0297]     | 二叉树的序列化与反序列化          | 困难 |          18:06          | 注意不要用-当分割符号, 用例有负数                                                         |
| [0300][0300]     | 最长递增子序列               | 中等 |           ⚠️            | 动态规划, 再练; 贪心+二分也可, 效率更高                                                    |                                                                   |
| [0328][0328]     | 奇偶链表                  | 中等 |          9:46           | 题目理解错了, 以为是节点值的奇偶, 结果是节点位置的奇偶。差别不大, 上次也是自己写出来的                             |
| [0331][0331]     | 验证二叉树的前序序列化           | 中等 |     31:52<br>03:21      | 消消乐, 但花的时间有点久 <br> 直接计数且不用split, 数字数量+1=#数量                                |
| [0337][0337]     | 打家劫舍III               | 中等 |           ⚠️            | 房屋是个二叉树,有点像[0098][0098]的后序遍历解法  @see[0189][0189]、[0213][0213]、[2560][2560] |
| [0448][0448]     | 找到所有数组中消失的数字          | 简单 |          03:26          | nums\[nums\[i]-1]-=n, 取nums\[i]>0的(i+1)加入结果数组                              |
| [0452][0452]     | 用最少数量的箭引爆气球           | 中等 |          08:29          | 排序, 右边距单指针右移即可                                                             |
| [0543][0543]     | 二叉树的直径                | 简单 |          03:55          | 秒了 跟官解一模一样 @see [0124][0124] 建议两道一起刷                                       |
| [0617][0617]     | 合并二叉树                 | 简单 |          03:46          | 递归秒了                                                                       |
| [0646][0646]     | 最长数对链                 | 中等 |          04:51          | 跟452一模一样,脑子已经不想其他解法了                                                       |
| [0647][0647]     | 回文子串                  | 中等 |          06:12          | 秒了, 耗时内存双百                                                                 |
| [0695][0695]     | 岛屿的最大面积               | 中等 |                         |                                                                            |
| [0712][0712]     | 两个字符串的最小ASCII删除和      | 中等 |          15:30          | ⚠️经典二维数组动态规划。@see [0072][0072]、[1143][1143]  建议三道一起刷                       |
| [0889][0889]     | 根据前序和后序遍历构造二叉树        | 中等 |                         |                                                                            |
| [1028][1028]     | 从先序遍历还原二叉树            | 困难 |                         |                                                                            |
| [1115][1115]     | 交替打印 FooBar           | 中等 |                         |                                                                            |
| [1143][1143]     | 最长公共子序列               | 中等 |          11:56          | 经典二维数组动态规划。@see [0072][0072]、[0712][0712]    建议三道一起刷                       |
| [2560][2560]     | 打家劫舍IV                | 中等 |         ⚠️理解不了          | 二分+dp 或 二分+贪心 @see[0189][0189]、[0213][0213]、[0337][0337]                   |
| [LCR155][LCR155] | 将二叉搜索树转化为排序的双向链表      | 中等 |                         |                                                                            |

[0001]: https://leetcode.cn/problems/two-sum/description/

[0002]: https://leetcode.cn/problems/add-two-numbers/description/

[0003]: https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

[0005]: https://leetcode.cn/problems/longest-palindromic-substring/description/

[0011]: https://leetcode.cn/problems/container-with-most-water/description/

[0015]: https://leetcode.cn/problems/3sum/description/

[0019]: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/

[0020]: https://leetcode.cn/problems/valid-parentheses/description/

[0021]: https://leetcode.cn/problems/merge-two-sorted-lists/description/

[0022]: https://leetcode.cn/problems/generate-parentheses/description/

[0033]: https://leetcode.cn/problems/search-in-rotated-sorted-array/description/

[0034]: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/

[0039]: https://leetcode.cn/problems/combination-sum/description/

[0042]: https://leetcode.cn/problems/trapping-rain-water/?envType=featured-list&envId=Fw9n57OM%3FenvType%3Dfeatured-list&envId=Fw9n57OM

[0048]: https://leetcode.cn/problems/rotate-image/description/

[0049]: https://leetcode.cn/problems/group-anagrams/description/

[0053]: https://leetcode.cn/problems/maximum-subarray/description/

[0055]: https://leetcode.cn/problems/jump-game/description/

[0056]: https://leetcode.cn/problems/merge-intervals/description/

[0062]: https://leetcode.cn/problems/unique-paths/description/

[0064]: https://leetcode.cn/problems/minimum-path-sum/description/

[0070]: https://leetcode.cn/problems/climbing-stairs/description/

[0072]: https://leetcode.cn/problems/edit-distance/description/

[0075]: https://leetcode.cn/problems/sort-colors/description/

[0078]: https://leetcode.cn/problems/subsets/description/

[0094]: https://leetcode.cn/problems/binary-tree-inorder-traversal/description/

[0096]: https://leetcode.cn/problems/unique-binary-search-trees/description/

[0098]: https://leetcode.cn/problems/validate-binary-search-tree/description/

[0101]: https://leetcode.cn/problems/symmetric-tree/description/

[0102]: https://leetcode.cn/problems/binary-tree-level-order-traversal/description/

[0103]: https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description

[0104]: https://leetcode.cn/problems/maximum-depth-of-binary-tree/description

[0105]: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description

[0106]: https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description

[0109]: https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description

[0111]: https://leetcode.cn/problems/minimum-depth-of-binary-tree/description

[0114]: https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description

[0121]: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description

[0122]: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description

[0124]: https://leetcode.cn/problems/binary-tree-maximum-path-sum/description

[0128]: https://leetcode.cn/problems/longest-consecutive-sequence/description/

[0129]: https://leetcode.cn/problems/sum-root-to-leaf-numbers/

[0136]: https://leetcode.cn/problems/single-number/description/

[0141]: https://leetcode.cn/problems/linked-list-cycle/description/

[0142]: https://leetcode.cn/problems/linked-list-cycle-ii/description

[0146]: https://leetcode.cn/problems/lru-cache/description/

[0148]: https://leetcode.cn/problems/sort-list/description

[0152]: https://leetcode.cn/problems/maximum-product-subarray/description/

[0155]: https://leetcode.cn/problems/min-stack/description/

[0160]: https://leetcode.cn/problems/intersection-of-two-linked-lists/description/

[0169]: https://leetcode.cn/problems/majority-element/description/

[0189]: https://leetcode.cn/problems/house-robber/description

[0200]: https://leetcode.cn/problems/number-of-islands/description/

[0206]: https://leetcode.cn/problems/reverse-linked-list/description/

[0209]: https://leetcode.cn/problems/minimum-size-subarray-sum/description/

[0213]: https://leetcode.cn/problems/house-robber-ii/description/

[0215]: https://leetcode.cn/problems/kth-largest-element-in-an-array/description/

[0225]: https://leetcode.cn/problems/implement-stack-using-queues/description/

[0226]: https://leetcode.cn/problems/invert-binary-tree/description/

[0234]: https://leetcode.cn/problems/palindrome-linked-list/description/

[0236]: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/

[0238]: https://leetcode.cn/problems/product-of-array-except-self/description/

[0283]: https://leetcode.cn/problems/move-zeroes/description/

[0287]: https://leetcode.cn/problems/find-the-duplicate-number/description/

[0297]: https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/

[0300]: https://leetcode.cn/problems/longest-increasing-subsequence/description/

[0328]: https://leetcode.cn/problems/odd-even-linked-list/description/

[0331]: https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/description/

[0337]: https://leetcode.cn/problems/house-robber-iii/description/

[0448]: https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/

[0452]: https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/

[0543]: https://leetcode.cn/problems/diameter-of-binary-tree/description/

[0617]: https://leetcode.cn/problems/merge-two-binary-trees/description/

[0646]: https://leetcode.cn/problems/maximum-length-of-pair-chain/description/

[0647]: https://leetcode.cn/problems/palindromic-substrings/description/

[0695]: https://leetcode.cn/problems/max-area-of-island/description/

[0712]: https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/description/

[0889]: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

[1028]: https://leetcode.cn/problems/recover-a-tree-from-preorder-traversal/description/

[1115]: https://leetcode.cn/problems/print-foobar-alternately/description/

[1143]: https://leetcode.cn/problems/longest-common-subsequence/description/

[2560]: https://leetcode.cn/problems/house-robber-iv/description/

[LCR155]: https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/description/

