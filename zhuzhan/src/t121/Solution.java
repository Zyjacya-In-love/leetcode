package t121;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author xzq
 * @create 2022-04-26-8:22
 */
//class Solution {
//    public int maxProfit(int[] prices) {
//        int minPrice = prices[0];
//        int maxProfit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
//            minPrice = Math.min(minPrice, prices[i]);
//        }
//        return maxProfit;
//    }
//}


/*
 * @create 2022-07-02-21:57
 */
// 贪心
// 只能买一次，卖一次
// 维护一个到当天之前的最小价格值，把这个值作为买入值，假设当天卖出获得的利润 用以 更新 总体最大利润
//class Solution {
//    public int maxProfit(int[] prices) {
//        int minPrice = prices[0];
//        int maxProfit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
//            minPrice = Math.min(minPrice, prices[i]);
//        }
//        return maxProfit;
//    }
//}
// 通过   2 ms	57.6 MB

// 动态规划
// dp[i][0] 表示第 i 天持有股票的 最大值
// dp[i][1] 表示第 i 天不持有股票的 最大值
// dp[i][0] = max(dp[i-1][0], -prices[i])
// dp[i][1] = max(dp[i-1][1], prices[i]+dp[i-1][0])
// 初始化：第 0 天持有股票 dp[0][0] = -prices[0]
//        第 0 天不持有股票 dp[0][1] = 0
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]);
        }
        return dp[n-1][1];
    }
}
// 通过   26 ms	54.2 MB