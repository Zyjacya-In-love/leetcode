package t322;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 * @author xzq
 * @create 2022-06-13-23:52
 */
//class Solution {
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
//                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//                }
//            }
//        }
//        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
//
//    }
//}


/*
 * @create 2022-06-26-23:45
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
// 通过   11 ms	41.3 MB