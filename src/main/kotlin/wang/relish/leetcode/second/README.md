| 题目           | 标题                    | 难度 |  时间   | 备注                                                                             |
|:-------------|:----------------------|:---|:-----:|:-------------------------------------------------------------------------------|
| [0001][0001] | 两数之和                  | 简单 | 3:43  | hash表                                                                          |
| [0002][0002] | 两数相加                  | 中等 | 8:10  |                                                                                |
| [0003][0003] | 无重复字符的最长子串            | 中等 | 8:16  | ⚠️ 滑动窗口, 边界处理                                                                  |
| [0005][0005] | 最长回文子串                | 中等 | 10:06 | ⚠️    expand法, 其他方法不太会                                                         |
| [0011][0011] | 盛最多水的容器               | 中等 | 4:37  | 双指针                                                                            |
| [0015][0015] | 三数之和                  | 中等 | 13:14 | ⚠️  需深度理解                                                                      |
| [0019][0019] | 删除链表的倒数第 N 个结点        | 中等 | 3:26  | 快慢指针                                                                           |
| [0020][0020] | 有效的括号                 | 简单 | 3:35  | Stack                                                                          |
| [0021][0021] | 合并两个有序链表              | 简单 | 7:33  | 快的                                                                             |
| [0022][0022] | 括号生成                  | 中等 | 4:26  | ⚠️ 理解一下dfs、回溯,再做一遍。                                                            |
| [0033][0033] | 搜索旋转排序数组              | 中等 | 12:04 | ⚠️ 二分法、考虑是否递增, 还要再加快                                                           |
| [0034][0034] | 在排序数组中查找元素的第一个和最后一个位置 | 中等 | 7:48  |                                                                                |
| [0039][0039] | 组合总和                  | 中等 | 16:26 | ⚠️ 回溯,剪枝 弱项                                                                    |
| [0048][0048] | 旋转图像                  | 中等 | 54:46 | ⚠️ 虽然还是自己做出来了, 但坐标转化弱项。多练                                                      |
| [0053][0053] | 最大子数组和                | 中等 | 15:18 | ⚠️ 动态规划,多练, 可以把dp数组去掉用一个变量代替                                                   |
| [0055][0055] | 跳跃游戏                  | 中等 | 11:29 | ⚠️ 哈希表存前期结果减少用时, 但还是O(n), 其实有更好的解法(记录能跳到的最远距离, 当遍历的i大于最远距离, 则false), 最坏情况才O(n) |
| [0056][0056] | 合并区间                  | 中等 | 38:33 | ⚠️ 太久, 思路捋清楚, 先排序怎么排                                                           |
| [0062][0062] | 不同路径                  | 中等 | 6:33  | 可优化,再说                                                                         |
| [0064][0064] | 最小路径和                 | 中等 | 4:29  | 和上一题很像                                                                         |
| [0070][0070] | 爬楼梯                   | 简单 | 3:11  | 斐波那契                                                                           |
| [0072][0072] | 编辑距离                  | 中等 | 3:11  | ⚠️还是要练。经典二维数组动态规划。@see [0712][0712]、[1143][1143] 建议三道一起刷                       |
|              |                       |    |       |                                                                                |
| [0712][0712] | 两个字符串的最小ASCII删除和      | 中等 |       | 经典二维数组动态规划。@see [0072][0072]、[1143][1143]  建议三道一起刷                             |
| [1143][1143] | 最长公共子序列               | 中等 |       | 经典二维数组动态规划。@see [0072][0072]、[0712][0712]    建议三道一起刷                           |

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

[0053]: https://leetcode.cn/problems/maximum-subarray/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0055]: https://leetcode.cn/problems/jump-game/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0056]: https://leetcode.cn/problems/merge-intervals/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0062]: https://leetcode.cn/problems/unique-paths/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0064]: https://leetcode.cn/problems/minimum-path-sum/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0070]: https://leetcode.cn/problems/climbing-stairs/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0072]: https://leetcode.cn/problems/edit-distance/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM

[0075]:

[0078]:
[0094]:

[0096]:
[0098]:

[0101]:
[0102]:

[0103]:
[0104]:

[0105]:
[0106]:

[0109]:
[0111]:

[0114]:
[0121]:

[0122]:
[0124]:

[0128]:
[0129]:

[0136]:
[0141]:

[0142]:
[0146]:

[0148]:
[0152]:

[0155]:
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
[0543]:

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


