package t392;

/**
 * 392. 判断子序列
 * https://leetcode.cn/problems/is-subsequence/
 * @author xzq
 * @create 2022-07-04-21:54
 */
// 一种动态规划思路：计算出 s 和 t 的最长公共子序列长度，看最长公共子序列长度和 s 的长度是否相等
// 直接复制 1143. 最长公共子序列 代码修改
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen+1][tLen+1];
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[sLen][tLen] == sLen;
    }
}
// 通过   6 ms	41.2 MB

// 另一种思考方式，往编辑距离方向去想，只删除 t 中字符，看 s 和 t 中相同子序列的长度和 s 的长度是否相等
// if (s[i - 1] == t[j - 1]) dp[i][j] = dp[i-1][j-1] + 1
// else                      dp[i][j] = dp[i][j-1];