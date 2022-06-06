package t70;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 * @author xzq
 * @create 2022-06-06-23:32
 */
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// 通过   0 ms	38.2 MB