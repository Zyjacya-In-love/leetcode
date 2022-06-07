package t1049;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode.cn/problems/last-stone-weight-ii/
 * @author xzq
 * @create 2022-06-07-23:30
 */
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int maxWeight = sum/2;
        int n = stones.length;
        int[][] dp = new int[n+1][maxWeight+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (j-stones[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i-1]]+stones[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return sum-dp[n][maxWeight]*2;
    }
}
// 通过   4 ms	39.4 MB