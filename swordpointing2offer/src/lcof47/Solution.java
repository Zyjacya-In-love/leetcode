package lcof47;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @author xzq
 * @create 2022-03-14-21:36
 */
class Solution {
    public int maxValue(int[][] grid) {
        int[] dp = new int[grid[0].length+1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[j+1] = Math.max(dp[j], dp[j+1]) + grid[i][j];
            }
        }
        return dp[grid[0].length];
    }
}
