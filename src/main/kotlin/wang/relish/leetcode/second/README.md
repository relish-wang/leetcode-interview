| 题目           | 标题                    | 难度 |    时间     | 备注                                                       |
|:-------------|:----------------------|:---|:---------:|:---------------------------------------------------------|
| [0001][0001] | 两数之和                  | 简单 |   3:43    | hash表                                                    |
| [0002][0002] | 两数相加                  | 中等 |   8:10    |                                                          |
| [0003][0003] | 无重复字符的最长子串            | 中等 |   8:16    | ⚠️ 滑动窗口, 边界处理                                            |
| [0005][0005] | 最长回文子串                | 中等 |   10:06   | ⚠️    expand法, 其他方法不太会                                   |
| [0011][0011] | 盛最多水的容器               | 中等 |   4:37    | 双指针                                                      |
| [0015][0015] | 三数之和                  | 中等 |   13:14   | ⚠️  需深度理解                                                |
| [0019][0019] | 删除链表的倒数第 N 个结点        | 中等 |   3:26    | 快慢指针                                                     |
| [0020][0020] | 有效的括号                 | 简单 |   3:35    | Stack                                                    |
| [0021][0021] | 合并两个有序链表              | 简单 |   3:56    | 快的, 进阶[0148][0148]                                       |
| [0022][0022] | 括号生成                  | 中等 |   4:26    | ⚠️ 理解一下dfs、回溯,再做一遍。                                      |
| [0033][0033] | 搜索旋转排序数组              | 中等 |   12:04   | ⚠️ 二分法、考虑是否递增, 还要再加快                                     |
| [0034][0034] | 在排序数组中查找元素的第一个和最后一个位置 | 中等 |   7:14    | 跟上一题差不多                                                  |
| [0039][0039] | 组合总和                  | 中等 | ~~16:26~~ | ⚠️ 回溯,剪枝 弱项                                              |
| [0048][0048] | 旋转图像                  | 中等 |   7:03    | 有机会再练练                                                   |
| [0049][0049] | 字母异位词分组               | 中等 |   1:06    | 哈希 groupby秒了                                             |
| [0053][0053] | 最大子数组和                | 中等 |   1:08    | dp️                                                      |
| [0055][0055] | 跳跃游戏                  | 中等 |   5:00    |                                                          |
| [0056][0056] | 合并区间                  | 中等 |   7:26    | 排序怎么排                                                    |
| [0062][0062] | 不同路径                  | 中等 |   6:33    | 可优化,再说                                                   |
| [0064][0064] | 最小路径和                 | 中等 |   4:29    | 和上一题很像                                                   |
| [0070][0070] | 爬楼梯                   | 简单 |   3:11    | 斐波那契                                                     |
| [0072][0072] | 编辑距离                  | 中等 |   4:00    | ⚠️还是要练。经典二维数组动态规划。@see [0712][0712]、[1143][1143] 建议三道一起刷 |
| [0075][0075] | 颜色分类                  | 中等 |    ⚠️     | 计数法没问题, 双指针要练(p0、p1, else if)                            |
| [0078][0078] | 子集                    | 中等 |   8:33    | 用dfs递归做出来了,也可以用二进制做                                      |
| [0074][0094] | 二叉树的中序遍历              | 简单 |   3:47    |                                                          |
| [0096][0096] | 不同的二叉搜索树              | 中等 |   4:00    | ⚠️ 卡特兰数记不住啊, 动态规划                                        |
| [0098][0098] | 验证二叉搜索树               | 中等 |   2:00    | 前序和中序可以在2分钟内解出来, 后序遍历解法全靠死记硬背(4分钟), 层序遍历没尝试              |
| [0101][0101] | 对称二叉树                 | 简单 |   2:25    | 秒了                                                       |
| [0102][0102] | 二叉树的层序遍历              | 中等 |   2:51    | 秒了                                                       |
| [0103][0103] | 二叉树的锯齿形层序遍历           | 中等 |   9:04    | 秒了, addFirst/removeFirst/addLast/removeLast              |
| [0104][0104] | 二叉树的最大深度              | 简单 |   0:51    | 递归秒了                                                     |
| [0105][0105] | 从前序与中序遍历序列构造二叉树       | 中等 |   17:35   | ⚠️ 边界注意                                                  |
| [0106][0106] | 从中序与后序遍历序列构造二叉树       | 中等 |   7:24    | 刷完上面那题秒了                                                 |
| [0109][0109] | 有序链表转换二叉搜索树           | 中等 |   16:59   | ⚠️~~自己摸索出来的从中间断开建树的方式~~。正统做法就是这个。但是我想得有点慢                |
| [0111][0111] | 二叉树的最小深度              | 简单 |   7:07    | 层序遍历，秒了                                                  |
| [0114][0114] | 二叉树展开为链表              | 中等 |   8:44    | 递归秒了                                                     |
| [0121][0121] | 买卖股票的最佳时机             | 简单 |   10:31   | 简单题理解错了, 只能交易一次                                          |
| [0122][0122] | 买卖股票的最佳时机II           | 中等 |   8:06    | 理解好边界问题, 秒了                                              |
| [0124][0124] | 二叉树中的最大路径和            | 困难 |   1:41    | 考虑清楚什么时候取较大值, 还有点模糊。建议先刷[0543][0543]                     |
| [0128][0128] | 最长连续序列                | 中等 |    ⚠️     | set.contains(num-1)                                      |
| [0129][0129] | 求根节点到叶节点数字之和          | 中等 |   5:20    | 队列秒了                                                     |
| [0136][0136] | 只出现一次的数字              | 简单 |   00:53   | 异或秒了                                                     |
| [0141][0141] | 环形链表                  | 简单 |   2:29    | 快慢指针秒了                                                   |
| [0142][0142] | 环形链表II                | 中等 |   10:33   | 快慢指针相遇后, 再走一个慢指针2, 当慢指针1和慢指针2相遇, 则是环入口                   |
| [0146][0146] | LRU 缓存                | 中等 |   08:53   | LinkedHashMap能秒, 但你必须会写双向链表(一遍过都需要8分多钟)                  |
| [0148][0148] | 排序链表                  | 中等 | ⚠️ 14:08  | ~~归并还是递归好理解。~~ 还得用归并, 题目要求O(1)空间复杂度 复习一下[0021][0021]     |
| [0152][0152] | 乘积最大子数组               | 中等 |   07:14   | 因为负数的存在需要min和max两个dp数组, dp\[i]表示以nums\[i]结尾的连续数组的最大/小乘积值 |
| [0155][0155] | 最小栈                   | 中等 |   05:51   | 不用辅助栈, 单链表秒了, 每个node多存一个当前最小值                            |
|              |                       |    |           |                                                          |
| [0543][0543] | 二叉树的直径                | 简单 |   03:55   | 秒了 跟官解一模一样 @see [0124][0124] 建议两道一起刷                     |
| [0712][0712] | 两个字符串的最小ASCII删除和      | 中等 |   15:30   | ⚠️经典二维数组动态规划。@see [0072][0072]、[1143][1143]  建议三道一起刷     |
| [1143][1143] | 最长公共子序列               | 中等 |   11:56   | 经典二维数组动态规划。@see [0072][0072]、[0712][0712]    建议三道一起刷     |

[0001]: https://leetcode.cn/problems/two-sum/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0002]: https://leetcode.cn/problems/add-two-numbers/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0003]: https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0005]: https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0011]: https://leetcode.cn/problems/container-with-most-water/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0015]: https://leetcode.cn/problems/3sum/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0019]: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0020]: https://leetcode.cn/problems/valid-parentheses/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0021]: https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0022]: https://leetcode.cn/problems/generate-parentheses/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0033]: https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0034]: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0039]: https://leetcode.cn/problems/combination-sum/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0042]: https://leetcode.cn/problems/trapping-rain-water/?envType=featured-list&envId=Fw9n57OM%3FenvType%3Dfeatured-list&envId=Fw9n57OM

[0048]: https://leetcode.cn/problems/rotate-image/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0049]: https://leetcode.cn/problems/group-anagrams/description/

[0053]: https://leetcode.cn/problems/maximum-subarray/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0055]: https://leetcode.cn/problems/jump-game/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0056]: https://leetcode.cn/problems/merge-intervals/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0062]: https://leetcode.cn/problems/unique-paths/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0064]: https://leetcode.cn/problems/minimum-path-sum/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0070]: https://leetcode.cn/problems/climbing-stairs/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0072]: https://leetcode.cn/problems/edit-distance/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0075]: https://leetcode.cn/problems/sort-colors/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0078]: https://leetcode.cn/problems/subsets/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0094]: https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0096]: https://leetcode.cn/problems/unique-binary-search-trees/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0098]: https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0101]: https://leetcode.cn/problems/symmetric-tree/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0102]: https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

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

[0160]:

[0169]:
[0189]:

[0200]:
[0206]:

[0209]:
[0215]:

[0225]:
[0226]:

[0234]:
[0236]:

[0238]:
[0283]:

[0287]:
[0297]:

[0300]:
[0328]:

[0331]:
[0448]:

[0482]:

[0543]: https://leetcode.cn/problems/diameter-of-binary-tree/description/

[0617]:
[0646]:

[0647]:
[0695]:

[0712]: https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/description/

[0889]:
[1028]:

[1115]:
[LCR115]:

[1143]: https://leetcode.cn/problems/longest-common-subsequence/description/


