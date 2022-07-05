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
//class Solution {
//    public int minDistance(String word1, String word2) {
//        int len1 = word1.length();
//        int len2 = word2.length();
//        int[] dp = new int[len2+1];
//        for (int j = 0; j <= len2; j++) {
//            dp[j] = j;
//        }
//        for (int i = 1; i <= len1; i++) {
//            int pre = i-1;
//            dp[0] = i;
//            for (int j = 1; j <= len2; j++) {
//                int tmp = dp[j];
//                if (word1.charAt(i-1) == word2.charAt(j-1)) {
//                    dp[j] = pre;
//                } else {
//                    dp[j] = Math.min(Math.min(dp[j-1], dp[j]), pre)+1;
//                }
//                pre = tmp;
//            }
//        }
//        return dp[len2];
//    }
//}


/*
 * @create 2022-07-05-12:51
 */
// 和 115. 不同的子序列、583. 两个字符串的删除操作 的区别是
//              115. 不同的子序列             删除一个字符串 s
//              583. 两个字符串的删除操作      两个字符串都可以删除
//              72. 编辑距离                  一个字符串 word1 可以删除、插入、替换
// 定义：dp[i][j] word1[0:i] 转换成 word2[0:j] 所使用的最少操作数
// 状态转移：if(word1[i] == word2[j]) dp[i][j] = dp[i-1][j-1]
//          else                     dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
//                  插入 word2[j]，即 word1[0:i]+word2[j] == word2[0:j-1]+word2[j] ：dp[i][j-1]+1
//                  删除 word1[i]，即 word1[0:i-1] == word2[0:j] ：dp[i-1][j]+1
//                  替换 word1[i]，即 word1[0:i-1]+word2[j] == word2[0:j-1]+word2[j] ：dp[i-1][j-1]+1
// 初始化：dp[i][0] 表示 word2 是空串，word1 转换成 空串 只有一种方式：删除 word1 所有字符，所以 dp[i][0] = i
//        dp[0][j] 表示 word1 是空串，空串 转换成 word2 只有一种方式：插入 word2 所有字符，所以 dp[0][j] = j
//        dp[0][0] 表示 word1 和 word2 都是空串，空串 转换成 空串 无需操作，所以 dp[0][0] = 0
// 遍历顺序：更新依赖于 左上角、上侧、左侧 故 先正序 word1 再正序 word2
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
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
// 通过   4 ms	41.6 MB