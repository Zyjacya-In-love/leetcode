package t516;

/**
 * 516. 最长回文子序列
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * @author xzq
 * @create 2022-04-30-13:23
 */
//class Solution {
//    public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
//        for (int i = n-2; i >= 0; i--) {
//            for (int j = i+1; j < n; j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = dp[i+1][j-1]+2;
//                } else {
//                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[0][n-1];
//    }
//}
//	31 ms	50.7 MB

// 滚动数组优化
//class Solution {
//    public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//        }
//        for (int i = n-2; i >= 0; i--) {
//            int pre = 0;
//            for (int j = i+1; j < n; j++) {
//                int tmp = dp[j];
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[j] = pre+2;
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j-1]);
//                }
//                pre = tmp;
//            }
//        }
//        return dp[n-1];
//    }
//}
// 	30 ms	39.7 MB

// 字符串变字符数组
//class Solution {
//    public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        char[] charArr = s.toCharArray();
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//        }
//        for (int i = n-2; i >= 0; i--) {
//            int pre = 0;
//            for (int j = i+1; j < n; j++) {
//                int tmp = dp[j];
//                if (charArr[i] == charArr[j]) {
//                    dp[j] = pre+2;
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j-1]);
//                }
//                pre = tmp;
//            }
//        }
//        return dp[n-1];
//    }
//}
// 10 ms	39.5 MB


/*
 * @create 2022-07-05-15:21
 */
// 定义：dp[i][j] s[i:j] 中最长的回文子序列的长度
// 状态转移：if(s[i]==s[j]) dp[i][j] = dp[i+1][j-1]+2
//          else           dp[i][j] = max(dp[i+1][j], dp[i][j-1])
// 初始化：dp[i][i] = 1
// 遍历顺序：更新依赖于 左下角、左侧、下侧 因此 先逆序 s 再 正序 s
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
// 通过   34 ms	51.1 MB