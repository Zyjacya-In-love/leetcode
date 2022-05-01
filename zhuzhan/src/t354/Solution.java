package t354;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * @author xzq
 * @create 2022-04-29-22:30
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a1, a2) -> a1[0] == a2[0] ? a2[1]-a1[1] : a1[0]-a2[0]);
        // LIS
        int len = 0;
        int n = envelopes.length;
        int[] dp = new int[n];
        for (int[] envelope : envelopes) {
            int h = envelope[1];
            if (len == 0 || dp[len-1] < h) {
                dp[len++] = h;
            } else {
                int s = 0, t = len;
                while (s < t) {
                    int m = ((s+t)>>1);
                    if (dp[m] >= h) {
                        t = m;;
                    } else {
                        s = m+1;
                    }
                }
                dp[s] = h;
            }
        }
        return len;
    }
}
