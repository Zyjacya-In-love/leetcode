package t312;

import java.util.Arrays;

/**
 * 312. 戳气球
 * https://leetcode-cn.com/problems/burst-balloons/
 * @author xzq
 * @create 2022-05-01-18:12
 */
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        balloons[0] = balloons[n+1] = 1;
        System.arraycopy(nums, 0, balloons, 1, n);
        int[][] dp = new int[n+2][n+2];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+2; j < n+2; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k][j] + balloons[i]*balloons[k]*balloons[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}