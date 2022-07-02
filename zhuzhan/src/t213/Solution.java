package t213;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author xzq
 * @create 2022-05-01-19:43
 */
//class Solution {
//    public int rob(int[] nums) {
//        int n = nums.length;
//        int[] dp1 = new int[n+1];
//        int[] dp2 = new int[n+1];
//        dp1[1] = nums[0];
//        for (int i = 2; i < n; i++) {
//            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i-1]);
//        }
//        dp2[n] = nums[n-1];
//        for (int i = 2; i <= n; i++) {
//            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i-1]);
//        }
//        return Math.max(dp1[n-1], dp2[n]);
//    }
//}
// 通过   0 ms	38.8 MB


/*
 * @create 2022-07-02-21:03
 */
// 和 198. 打家劫舍 的区别在于 所有房屋 围成一圈
// 有两种可能：① 偷 [1,n-1] ② 偷 [2,n]。这样可以保证 偷 1 不会偷 n，偷 n 不会偷 1
// dp[i] = max(dp[i-1], dp[i-2]+robs[i]);
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        // [2,n]
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        // [1,n-1]
        dp[1] = nums[0];
        for (int i = 2; i <= n-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return Math.max(dp[n], dp[n-1]);
    }
}
// 通过   0 ms	38.8 MB