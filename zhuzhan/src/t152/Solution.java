package t152;

/**
 * 152. 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/
 * @from leetcode top145
 * @author xzq
 * @create 2022-07-18-19:44
 */
// 定义：dp[0][i] 以 i 为结尾，最大的连续乘积
//       dp[1][i] 以 i 为结尾，最小的连续乘积
// 状态转移：dp[0][i] = max(max(dp[0][i-1]*nums[i], nums[i]), dp[1][i-1]*nums[i])
//          dp[1][i] = min(min(dp[1][i-1]*nums[i], nums[i]), dp[0][i-1]*nums[i])
// 初始化：dp[0][0] = nums[0]
//        dp[1][0] = nums[0]
// 遍历顺序：dp[0\1][i] 依赖于前一个元素，所以 正序 nums
// 错 1. 次：思路不对，这是乘法不是加法，不能一直乘下去，每次拿最大值，乘法有正有负，不是单调递增的，可能先减后增，eg：[-2,3,-4]
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0]; // 错 2. 次：错写成 dp[0][1] 了
        int res = dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(Math.max(dp[0][i-1]*nums[i], nums[i]), dp[1][i-1]*nums[i]);
            dp[1][i] = Math.min(Math.min(dp[1][i-1]*nums[i], nums[i]), dp[0][i-1]*nums[i]);
            res = Math.max(res, dp[0][i]);
        }
        return res;
    }
}
// 通过   3 ms	41.3 MB