package t1312;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 * https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * @author xzq
 * @create 2022-04-30-13:37
 */
//class Solution {
//    public int minInsertions(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = n-2; i >= 0; i--) {
//            for (int j = i+1; j < n; j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = dp[i+1][j-1];
//                } else {
//                    dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j])+1;
//                }
//            }
//        }
//        return dp[0][n-1];
//    }
//}
// 	15 ms	42.7 MB

// 滚动数组优化空间
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n-2; i >= 0; i--) {
            int pre = 0;
            for (int j = i+1; j < n; j++) {
                int tmp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j])+1;
                }
                pre = tmp;
            }
        }
        return dp[n-1];
    }
}
// 13 ms	39.5 MB