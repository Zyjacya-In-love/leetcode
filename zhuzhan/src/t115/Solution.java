package t115;

import java.util.Arrays;

/**
 * 115. 不同的子序列
 * https://leetcode.cn/problems/distinct-subsequences/
 * @author xzq
 * @create 2022-07-04-22:13
 */
// 编辑距离的思想，
//      删除 s 中的字符，与 t 匹配
// 定义：dp[i][j] s[0:i] 的子序列中 以 t[j] 为结尾的 t[0:j] 出现的个数
// 状态转移：if(s[i]==t[j]) dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
//          else           dp[i][j] = dp[i-1][j]
// 初始化：dp[i][0] 表示 t 是空串，那么当且仅当删除 s 中所有字符可匹配空串，故 dp[i][0] = 1，
//        dp[0][j] 表示 s 是空串，t 不是空串，则无论如何删除 s 都不可能匹配，所以 dp[0][j] = 0
//        dp[0][0] 表示 s 是空串 t 是空串，那么无需操作即可匹配且无法操作，因此 dp[0][0] = 1
// 遍历顺序：更新依赖于 左上角 和 上侧 所以 先正序 s 再正序 t
class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen+1][tLen+1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
// 通过   13 ms	48.3 MB
