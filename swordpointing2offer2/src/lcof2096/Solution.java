package lcof2096;

/**
 * 剑指 Offer II 096. 字符串交织
 * https://leetcode-cn.com/problems/IY6buf/
 * @author xzq
 * @create 2022-03-08-10:04
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l = s3.length(), n = s1.length(), m = s2.length();
        if (l != m+n) return false;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = (s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]);
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = (s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = ((s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]));
            }
        }
        return dp[n][m];
    }
}
