package t1864;

/**
 * 1864. 构成交替字符串需要的最小交换次数
 * https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 * @author xzq
 * @create 2022-04-14-22:39
 */
public class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') cnt1++;
        }
        if (Math.abs(n-2*cnt1) > 1) return -1;
        int diff0 = 0, diff1 = 0;
        for (int i = 0; i < n; i++) {
            if ((s.charAt(i)-'0') != (i&1)) {
                // 01
                diff0++;
            } else {
                // 10
                diff1++;

            }
        }
        return (n&1)==1 ? ((cnt1 > n/2) ? diff1/2 : diff0/2) : Math.min(diff0/2, diff1/2);
    }
}
