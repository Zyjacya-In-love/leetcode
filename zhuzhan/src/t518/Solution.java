package t518;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 * @author xzq
 * @create 2022-05-01-19:03
 */
//class Solution {
//    public int change(int amount, int[] coins) {
//        int n = coins.length;
//        int[][] dp = new int[n+1][amount+1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if (j >= coins[i-1]) {
//                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
//                } else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[n][amount];
//    }
//}
// 通过   5 ms	48 MB

// 滚动数组优化空间
//class Solution {
//    public int change(int amount, int[] coins) {
//        int n = coins.length;
//        int[] dp = new int[amount+1];
//        dp[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if (j >= coins[i-1]) {
//                    dp[j] = dp[j] + dp[j-coins[i-1]];
//                } else {
//                    dp[j] = dp[j];
//                }
//            }
//        }
//        return dp[amount];
//    }
//}
// 通过   5 ms	38.9 MB


/*
 * @create 2022-06-12-10:52
 */
//class Solution {
//    public int change(int amount, int[] coins) {
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                dp[j] += dp[j - coins[i]];
//            }
//        }
//        return dp[amount];
//    }
//}


/*
 * @create 2022-06-21-23:44
 */
//class Solution {
//    public int change(int amount, int[] coins) {
//        int[][] dp = new int[coins.length+1][amount+1];
//        for (int i = 0; i <= coins.length; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i <= coins.length; i++) {
//            for (int j = 1; j <= amount; j++) {
//                dp[i][j] = dp[i-1][j];
//                if (j-coins[i-1] >= 0) {
//                    dp[i][j] += dp[i][j-coins[i-1]];
//                }
//            }
//        }
//        return dp[coins.length][amount];
//    }
//}
// 通过   5 ms	47.8 MB

// 滚动数组
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
// 通过   2 ms	39 MB