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
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] charArr1 = text1.toCharArray();
        char[] charArr2 = text2.toCharArray();
        int[] dp = new int[len2+1];
        for (int i = 1; i <= len1; i++) {
            int pre = 0;
            for (int j = 1; j <= len2; j++) {
                int tmp = dp[j];
                if (charArr1[i-1] == charArr2[j-1]) {
                    dp[j] = pre+1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                pre = tmp;
            }
        }
        return dp[len2];
    }
}