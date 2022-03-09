package t2055;

import java.util.Arrays;

/**
 * 2055. 蜡烛之间的盘子
 * https://leetcode-cn.com/problems/plates-between-candles/
 * @author xzq
 * @create 2022-03-08-13:07
 */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int starCnt = 0;
        int[] sum = new int[s.length()];
        int[] nearRightCol = new int[s.length()];
        int lastRightColPos = s.length();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastRightColPos = i;
            }
            nearRightCol[i] = lastRightColPos;
        }
        for (int i = 1; i < s.length(); i++) {
            sum[i] = sum[i-1];
            if (s.charAt(i) == '*') {
                starCnt++;
            } else {
                sum[i] += starCnt;
                starCnt = 0;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int l = nearRightCol[query[0]];
            int r = query[1];
            if (l > r) continue;
            ans[i] = sum[r] - sum[l];
        }
        return ans;
    }
}
