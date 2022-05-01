package t213;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author xzq
 * @create 2022-05-01-19:43
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        dp1[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i-1]);
        }
        dp2[n] = nums[n-1];
        for (int i = 2; i <= n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i-1]);
        }
        return Math.max(dp1[n-1], dp2[n]);
    }
}
// 通过   0 ms	38.8 MB