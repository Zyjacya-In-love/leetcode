package t188;

/**
 * 188. 买卖股票的最佳时机 IV
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 * @author xzq
 * @create 2022-07-03-9:45
 */
// 和 121. 买卖股票的最佳时机、122. 买卖股票的最佳时机 II、123. 买卖股票的最佳时机 III 的区别是
//          121. 买卖股票的最佳时机 只能买一次，卖一次
//          122. 买卖股票的最佳时机 II 可以多次买卖股票
//          123. 买卖股票的最佳时机 III 最多可以买卖两次
//          188. 买卖股票的最佳时机 IV 最多可以买卖 k 次
// dp[k][i][0] k 笔交易 第 i 天 持有股票的 最大利润
// dp[1][i][1] k 笔交易 第 i 天 不持有股票的 最大利润
// dp[k][i][0] = max(dp[k][i-1][0], dp[k-1][i-1][1]-prices[i])
// dp[k][i][1] = max(dp[k][i-1][1], prices[i]+dp[k][i-1][0])
// 初始化：   dp[1][0][0] = dp[2][0][0] = ... = dp[k][0][0] = ... = -prices[0]
//           dp[k][i][1] = 0
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        int[][][] dp = new int[k+1][n][2];
        for (int i = 1; i <= k; i++) {
            dp[i][0][0] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[j][i][0] = Math.max(dp[j][i-1][0], dp[j-1][i-1][1]-prices[i]);
                dp[j][i][1] = Math.max(dp[j][i-1][1], prices[i]+dp[j][i-1][0]);
            }
        }
        return dp[k][n-1][1];
    }
}
// 通过   5 ms	41.7 MB