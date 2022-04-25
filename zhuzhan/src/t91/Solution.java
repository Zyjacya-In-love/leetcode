package t91;

import java.util.Arrays;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @author xzq
 * @create 2022-04-25-9:08
 */
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = dp[1]= 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && (s.charAt(i-1) >= '0' && s.charAt(i-1) <= '6'))) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
