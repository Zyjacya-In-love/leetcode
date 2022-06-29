package t139;

import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break/
 * @author xzq
 * @create 2022-06-29-23:42
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        boolean[] dp = new boolean[sLen+1];
        dp[0] = true;
        for (int j = 1; j <= sLen; j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                int wordLength = wordDict.get(i).length();
                if (j-wordLength >= 0 && wordDict.get(i).equals(s.substring(j-wordLength, j))) {
                    dp[j] |= dp[j-wordLength];
                }
            }
        }
        return dp[sLen];
    }
}
// 通过   7 ms	41.4 MB