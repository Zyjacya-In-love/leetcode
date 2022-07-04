package t1143;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @author xzq
 * @create 2022-04-29-23:22
 */
//class Solution {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int len1 = text1.length();
//        int len2 = text2.length();
//        int[][] dp = new int[len1+1][len2+1];
//        for (int i = 1; i <= len1; i++) {
//            for (int j = 1; j <= len2; j++) {
//                if (text1.charAt(i-1) == text2.charAt(j-1)) {
//                    dp[i][j] = dp[i-1][j-1]+1;
//                } else {
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[len1][len2];
//    }
//}

// 滚动数组优化空间
//class Solution {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int len1 = text1.length();
//        int len2 = text2.length();
//        int[] dp = new int[len2+1];
//        for (int i = 1; i <= len1; i++) {
//            int pre = 0;
//            for (int j = 1; j <= len2; j++) {
//                int tmp = dp[j];
//                if (text1.charAt(i-1) == text2.charAt(j-1)) {
//                    dp[j] = pre+1;
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j-1]);
//                }
//                pre = tmp;
//            }
//        }
//        return dp[len2];
//    }
//}

// 字符串变数组优化
//class Solution {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int len1 = text1.length();
//        int len2 = text2.length();
//        char[] charArr1 = text1.toCharArray();
//        char[] charArr2 = text2.toCharArray();
//        int[] dp = new int[len2+1];
//        for (int i = 1; i <= len1; i++) {
//            int pre = 0;
//            for (int j = 1; j <= len2; j++) {
//                int tmp = dp[j];
//                if (charArr1[i-1] == charArr2[j-1]) {
//                    dp[j] = pre+1;
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j-1]);
//                }
//                pre = tmp;
//            }
//        }
//        return dp[len2];
//    }
//}


/*
 * @create 2022-07-04-21:11
 */
// 定义：dp[i][j] 是 text1[0:i] 和 text2[0:j] 这两个子串的最长公共子序列的长度
// 状态转移：if(text1[i]==text2[j]) dp[i][j] = dp[i-1][j-1]+1
//          else                   dp[i][j] = max(dp[i-1][j], dp[i][j-1])
// 初始化：dp[i][0] = 0，dp[0][j] = 0
// 遍历顺序：更新 依赖于左上角，左侧，上侧 元素 所以 先正序 text1，再正序 text2
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Chars = text1.toCharArray();
        char[] text2Chars = text2.toCharArray();
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1Chars[i-1] == text2Chars[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
// 通过   5 ms	45.1 MB