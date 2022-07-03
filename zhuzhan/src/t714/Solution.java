package t714;

/**
 * 714. 买卖股票的最佳时机含手续费
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author xzq
 * @create 2022-06-03-9:14
 */
//      DP：dp[i][0] 0-i 之间最后的状态是买的最大利润，就是当前手里有一支股票的最大利润
//          dp[i][1] 0-i 之间最后的状态是卖的最大利润，就是当前手里没有股票的最大利润，
//                  并且卖的时候要减掉手续费 fee（买的时候减fee也可以）
//          初始值：dp[i][0] 买 = -price[0]，dp[i][1] 没得卖 = 0
//          结果：因为是之间，所以看最后一个元素，且 dp[n-1][1] > dp[n-1][0]
//class Solution {
//    public int maxProfit(int[] prices, int fee) {
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]-fee);
//        }
//        return dp[n-1][1];
//    }
//}
// 通过   18 ms	48.9 MB

//      贪心：买入的时候计入手续费，如果 当前价格+手续费 小于买入价，将买入价更新为 当前价格+手续费，
//                              如果 当前价格 大于 买入价，卖出，并更新买入价为 当前价格，
//                                  这是因为如果后面还有更大的价格，可以继续卖出，相当于更换卖出时间
//      为什么买入的时候计入手续费，而不是卖出的时候计入？
//      因为如果卖出的时候计入，更新的买入价里没有手续费，那么买入价就偏低，
//          可能会在错误的位置更新买入价，导致多买卖，多交手续费，eg：[1,3,7,5,10,3], fee = 3
// 官解的一句话非常好：当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
//class Solution {
//    public int maxProfit(int[] prices, int fee) {
//        int res = 0;
//        int buy = prices[0]+fee;
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i]+fee < buy) {
//                buy = prices[i]+fee;
//            } else if (prices[i] > buy){
//                res += prices[i]-buy;
//                buy = prices[i];
//            }
//        }
//        return res;
//    }
//}
// 通过   3 ms	49.3 MB


/*
 * @create 2022-07-03-10:29
 */
// 和 121. 买卖股票的最佳时机、122. 买卖股票的最佳时机 II、123. 买卖股票的最佳时机 III、188. 买卖股票的最佳时机 IV、309. 最佳买卖股票时机含冷冻期 的区别是
//          121. 买卖股票的最佳时机 只能买一次，卖一次
//          122. 买卖股票的最佳时机 II 可以多次买卖股票
//          123. 买卖股票的最佳时机 III 最多可以买卖两次
//          188. 买卖股票的最佳时机 IV 最多可以买卖 k 次
//          309. 最佳买卖股票时机含冷冻期 可以多次买卖股票，但是卖出股票后，无法在第二天买入股票 (即冷冻期为 1 天)。
//          714. 买卖股票的最佳时机含手续费 可以多次买卖股票，但是每笔交易都需要额外付手续费
// dp[i][0] 第 i 天 持有股票的最大利润
// dp[i][1] 第 i 天 不持有股票的最大利润
// dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i]-fee) // 买入的时候付手续费，相当于所有买入价增加 fee 元
// dp[i][1] = max(dp[i-1][1], prices[i]+dp[i-1][0])
// 初始化：dp[0][0] = -prices[0]-fee // 买入的时候付手续费，相当于所有买入价增加 fee 元
//        dp[0][1] = 0
// 补充说明：卖出的时候付手续费也可以，相当于所有卖出价减少了 fee 元
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0]-fee; // 买入的时候付手续费
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]-fee); // 买入的时候付手续费
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]);
        }
        return dp[n-1][1];
    }
}
// 通过   18 ms	48.5 MB