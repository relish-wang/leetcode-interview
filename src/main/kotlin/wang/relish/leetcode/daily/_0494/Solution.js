/**
 * 回溯解法
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function (nums, target) {
    var n = nums.length
    var count = 0
    var test = (nums, target, index, sum) => {
        if (index === n) {
            if (sum === target) {
                count++
            }
        } else {
            test(nums, target, index + 1, sum + nums[index])
            test(nums, target, index + 1, sum - nums[index])
        }
    }
    test(nums, target, 0, 0)
    return count
};