package t583;

import java.util.Arrays;

/**
 * 583. 两个字符串的删除操作
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 * @author xzq
 * @create 2022-07-05-12:15
 */
// 和 115. 不同的子序列 的区别是
//              115. 不同的子序列 删除一个字符串 s
//              583. 两个字符串的删除操作 两个字符串都可以删除
// 编辑距离，两个字符串都可以删除操作
// 定义：dp[i][j] word1[0:i] 和 word2[0:j] 相同所需的最小删除字符数
// 状态转移：if(word1[i]==word2[j]) dp[i][j] = dp[i-1][j-1]
//          else                   dp[i][j] = min(dp[i-1][j], dp[i][j-1])+1 // 删掉 word1[i] 或者 word2[j]
// 初始化：dp[i][0] 表示 word2 是空串，只有删除 word1[0:i] 全部字符才能相同，dp[i][0] = i
//        dp[0][j] 表示 word1 是空串，只有删除 word2[0:j] 全部字符才能相同，dp[0][j] = j
//        dp[0][0] 表示 word1 和 word2 都是空串，不需要删除已经相同，dp[0][0] = 0
// 遍历顺序：更新依赖于 左上角、上侧、左侧 的元素，故 先正序 word1 再正序 word2
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
// 通过   6 ms	42.1 MB


// 思路二：非常巧妙，求 word1 和 word2 的最长公共子序列，除了最长公共子序列之外的字符都删了，删除的数量就是最小的删除数