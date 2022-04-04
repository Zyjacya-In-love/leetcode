package lcof19;

import java.util.Arrays;

/**
 * 剑指 Offer 19. 正则表达式匹配
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * @author xzq
 * @create 2022-04-03-20:39
 */
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for (int i = 2; i < p.length() + 1; i++) {
            if (p.charAt(i-1) == '*') {
                dp[i][0] = dp[i-2][0];
            }
        }
        for (int i = 1; i < p.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (p.charAt(i-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(i-1) == '*') {
                    if (p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2) == '.') {
                        dp[i][j] = (dp[i-2][j] || dp[i-1][j] || dp[i-1][j-1] || dp[i][j-1]);
                    } else {
                        dp[i][j] = dp[i-2][j];
                    }
                } else {
                    dp[i][j] = (p.charAt(i-1) == s.charAt(j-1) && dp[i-1][j-1]);
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
