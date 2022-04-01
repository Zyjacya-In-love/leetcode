package lcof67;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * @author xzq
 * @create 2022-03-31-21:51
 */
class Solution {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int ans = 0;
        int bound = Integer.MAX_VALUE/10;
        int startPos = 1;
        int sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
        } else if (str.charAt(0) != '+') {
            startPos = 0;
        }
        for (int i = startPos; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                break;
            }
            int x = str.charAt(i) - '0';
            if (ans > bound || (ans == bound && x > 7)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + x;
        }
        return sign * ans;
    }
}