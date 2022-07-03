package t123;

/**
 * 123. 买卖股票的最佳时机 III
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @author xzq
 * @create 2022-07-03-9:22
 */
// 和 121. 买卖股票的最佳时机、122. 买卖股票的最佳时机 II 的区别是
//          121. 买卖股票的最佳时机 只能买一次，卖一次
//          122. 买卖股票的最佳时机 II 可以多次买卖股票
//          123. 买卖股票的最佳时机 III 最多可以买卖两次
// dp[1][i][0] 一笔交易 第 i 天 持有股票的 最大利润
// dp[1][i][1] 一笔交易 第 i 天 不持有股票的 最大利润
// dp[2][i][0] 两笔交易 第 i 天 持有股票的 最大利润
// dp[2][i][1] 两笔交易 第 i 天 不持有股票的 最大利润
// dp[1][i][0] = max(dp[1][i-1][0], -prices[i])
// dp[1][i][1] = max(dp[1][i-1][1], prices[i]+dp[1][i-1][0])
// dp[2][i][0] = max(dp[2][i-1][0], dp[1][i-1][1]-prices[i])
// dp[2][i][1] = max(dp[2][i-1][1], prices[i]+dp[2][i-1][0])
// 补充说明：  dp[1][i][x] 和 121 是完全一致的
//            dp[2][i][x] 和 122 是类似的
// 初始化：dp[1][0][0] = -prices[0]
//        dp[1][0][1] = 0
//        dp[2][0][0] = -prices[0]
//        dp[2][0][1] = 0
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[3][n][2];
        dp[1][0][0] = -prices[0];
        dp[1][0][1] = 0;
        dp[2][0][0] = -prices[0];
        dp[2][0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[1][i][0] = Math.max(dp[1][i-1][0], -prices[i]);
            dp[1][i][1] = Math.max(dp[1][i-1][1], prices[i]+dp[1][i-1][0]);
            dp[2][i][0] = Math.max(dp[2][i-1][0], dp[1][i-1][1]-prices[i]);
            dp[2][i][1] = Math.max(dp[2][i-1][1], prices[i]+dp[2][i-1][0]);
        }
        return dp[2][n-1][1];
    }
}
// 通过   52 ms	51.1 MB