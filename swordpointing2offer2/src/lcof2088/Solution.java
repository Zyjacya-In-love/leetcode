package lcof2088;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 * https://leetcode-cn.com/problems/GzCJIP/
 * @author xzq
 * @create 2022-03-08-10:03
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}
