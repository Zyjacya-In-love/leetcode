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
//class Solution {
//    public int rob(int[] nums) {
//        int n = nums.length;
//        int dp2 = 0;
//        int dp1 = nums[0];
//        int dp;
//        for (int i = 2; i <= n; i++) {
//            dp = Math.max(dp1, dp2+nums[i-1]);
//            dp2 = dp1;
//            dp1 = dp;
//        }
//        return dp1;
//    }
//}
// 通过   0 ms	38.4 MB


/*
 * @create 2022-07-02-20:52
 */
// dp[i] = max(dp[i-1], dp[i-2]+robs[i]);
// 把 dp[0] 空出来为 0，这样只需要赋值 dp[1] 为 nums[0] 非常巧妙
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
// 通过   0 ms	38.8 MB


/*
 * @from my unity exam 1006 1t
 * @create 2022-10-06-19:00
 */
class Solution {
    public int rob (int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}
// 通过   0 ms	39.2 MB