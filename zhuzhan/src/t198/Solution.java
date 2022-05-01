package t198;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @author xzq
 * @create 2022-05-01-19:34
 */
//class Solution {
//    public int rob(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n+1];
//        dp[1] = nums[0];
//        for (int i = 2; i <= n; i++) {
//            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
//        }
//        return dp[n];
//    }
//}
// 通过   0 ms	38.9 MB

// 滚动数组优化空间
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp2 = 0;
        int dp1 = nums[0];
        int dp;
        for (int i = 2; i <= n; i++) {
            dp = Math.max(dp1, dp2+nums[i-1]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
// 通过   0 ms	38.4 MB