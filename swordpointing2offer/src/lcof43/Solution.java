package lcof43;

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * @author xzq
 * @create 2022-04-05-9:52
 */
public class Solution {
    public int countDigitOne(int n) {
        String num = String.valueOf(n);
        int front = 0;
        int ans = 0;
        for (int i = 0; i < num.length(); i++) {
            int now = (num.charAt(i)-'0');
            String backStr = num.substring(i+1);
            int back = (backStr.equals("") ? 0 : Integer.parseInt(backStr));
            int back999 = (int) (Math.pow(10, backStr.length())) - 1;

            ans += (front*(back999+1));
            if (now > 1) {
                ans += (back999+1);
            } else if (now == 1) {
                ans += (back+1);
            }

            front = front*10 + now;
        }
        return ans;
    }
}
