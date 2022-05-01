package t887;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 * @author xzq
 * @create 2022-04-30-22:08
 */
// 纯暴力 O(KN^2)
//class Solution {
//    public int superEggDrop(int k, int n) {
//        int[][] dp = new int[k+1][n+1];
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = n+1;
//        }
//        for (int i = 1; i <= k; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//                for (int l = 1; l <= j; l++) {
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][l-1], dp[i][j-l])+1);
//                }
//            }
//        }
//        return dp[k][n];
//    }
//}
// 超出时间限制   N/A	N/A

// 二分优化  O(KNlogN)
//class Solution {
//    public int superEggDrop(int k, int n) {
//        int[][] dp = new int[k+1][n+1];
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = n+1;
//        }
//        for (int i = 1; i <= k; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//                int s = 1, t = j+1;
//                while (s < t) {
//                    int m = ((s+t)>>1);
//                    if (dp[i][j-m] > dp[i-1][m-1]) {
//                        s = m+1;
//                    } else {
//                        t = m;
//                    }
//                }
//                // 因为是取值是离散的，所以没法找到去确切的交点，
//                // 我的二分写法是找到第一个大于等于交点的点，也即是交点右侧第一个整数点，
//                // 因为交点两侧的第一个点不一定哪个点小，
//                // 所以还需要比较交点左侧的第一个点，也就是右侧第一个点减 1，减 1 的证明可用反正法
//                dp[i][j] = Math.max(dp[i-1][s-1], dp[i][j-s])+1;
//                if (s-1 >= 1) {
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][s-2], dp[i][j-s+1])+1);
//                }
//            }
//        }
//        return dp[k][n];
//    }
//}

// 换 dp 定义 优化 O(KN)
//class Solution {
//    public int superEggDrop(int k, int n) {
//        int[][] dp = new int[k+1][n+1];
//        int j = 1;
//        for (int i = 1; i <= k; i++) {
//            for (j = 1; dp[i][j-1] < n; j++) {
//                dp[i][j] = dp[i-1][j-1]+dp[i][j-1]+1;
//            }
//        }
//        return j-1;
//    }
//}
// 通过   4 ms	42.4 MB

// O(KN) 算法 滚动数组 优化空间
class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[n+1];
        int j = 1;
        for (int i = 1; i <= k; i++) {
            int pre = 0;
            for (j = 1; dp[j-1] < n; j++) {
                int tmp = dp[j];
                dp[j] = pre+dp[j-1]+1;
                pre = tmp;
            }
        }
        return j-1;
    }
}
// 通过   3 ms	40.3 MB