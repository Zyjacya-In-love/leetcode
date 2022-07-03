package t309;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author xzq
 * @create 2022-07-03-10:03
 */
// 和 121. 买卖股票的最佳时机、122. 买卖股票的最佳时机 II、123. 买卖股票的最佳时机 III、188. 买卖股票的最佳时机 IV 的区别是
//          121. 买卖股票的最佳时机 只能买一次，卖一次
//          122. 买卖股票的最佳时机 II 可以多次买卖股票
//          123. 买卖股票的最佳时机 III 最多可以买卖两次
//          188. 买卖股票的最佳时机 IV 最多可以买卖 k 次
//          309. 最佳买卖股票时机含冷冻期 可以多次买卖股票，但是卖出股票后，无法在第二天买入股票 (即冷冻期为 1 天)。
// dp[i][0] 第 i 天 持有股票的最大利润
// dp[i][1] 第 i 天 不持有股票的最大利润
// dp[i][0] = max(dp[i-1][0], dp[i-2][1]-prices[i])
// dp[i][1] = max(dp[i-1][1], prices[i]+dp[i-1][0])
// 初始化：dp[0][0] = -prices[0]
//        dp[0][1] = 0
//        dp[1][0] = max(dp[0][0], -prices[1])
//        dp[1][1] = max(dp[0][1], prices[1]+dp[0][0])
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], -prices[1]);
        dp[1][1] = Math.max(dp[0][1], prices[1]+dp[0][0]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]);
        }
        return dp[n-1][1];
    }
}
// 通过   1 ms	39.8 MB