package t343;

/**
 * 343. 整数拆分
 * https://leetcode.cn/problems/integer-break/
 * @author xzq
 * @create 2022-06-06-23:45
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i-1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
// 通过   1 ms	38.1 MB