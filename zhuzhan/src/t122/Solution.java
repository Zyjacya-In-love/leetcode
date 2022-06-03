package t122;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author xzq
 * @create 2022-04-26-8:37
 */
//class Solution {
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxProfit += Math.max(0, prices[i]-prices[i-1]);
//        }
//        return maxProfit;
//    }
//}


/*
 * @create 2022-06-03-8:41
 */
//      DP：dp[i][0] 0-i 之间最后的状态是买的最大利润，就是当前手里有一支股票的最大利润
//          dp[i][1] 0-i 之间最后的状态是卖的最大利润，就是当前手里没有股票的最大利润
//          初始值：dp[i][0] 买 = -price[0]，dp[i][1] 没得卖 = 0
//          结果：因为是之间，所以看最后一个元素，且 dp[n-1][1] > dp[n-1][0]
//class Solution {
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
//        }
//        return dp[n-1][1];
//    }
//}
// 通过   3 ms	41.4 MB

//    贪心，只要prices比前一天大就买前一天，在当天卖出，也就说只要两天之间有 >0 的利润就买卖
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i]-prices[i-1];
            if (profit > 0) {
                res += profit;
            }
        }
        return res;
    }
}
// 通过   1 ms	41 MB