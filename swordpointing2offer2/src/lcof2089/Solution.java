package lcof2089;

/**
 * 剑指 Offer II 089. 房屋偷盗
 * https://leetcode-cn.com/problems/Gu0c2T/
 * @author xzq
 * @create 2022-03-08-10:03
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}
