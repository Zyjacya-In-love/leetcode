package t72;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 * @author xzq
 * @create 2022-04-29-23:54
 */
//class Solution {
//    public int minDistance(String word1, String word2) {
//        int len1 = word1.length();
//        int len2 = word2.length();
//        int[][] dp = new int[len1+1][len2+1];
//        for (int i = 0; i <= len1; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 0; j <= len2; j++) {
//            dp[0][j] = j;
//        }
//        for (int i = 1; i <= len1; i++) {
//            for (int j = 1; j <= len2; j++) {
//                if (word1.charAt(i-1) == word2.charAt(j-1)) {
//                    dp[i][j] = dp[i-1][j-1];
//                } else {
//                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1])+1;
//                }
//            }
//        }
//        return dp[len1][len2];
//    }
//}
// 滚动数组优化空间
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2+1];
        for (int j = 0; j <= len2; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            int pre = i-1;
            dp[0] = i;
            for (int j = 1; j <= len2; j++) {
                int tmp = dp[j];
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(Math.min(dp[j-1], dp[j]), pre)+1;
                }
                pre = tmp;
            }
        }
        return dp[len2];
    }
}