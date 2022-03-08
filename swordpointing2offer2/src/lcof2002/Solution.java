package lcof2002;

/**
 * 剑指 Offer II 002. 二进制加法
 * https://leetcode-cn.com/problems/JFETK5/
 * @author xzq
 * @create 2022-03-08-9:15
 */
public class Solution {
    public String addBinary(String a, String b) {
        String re_a = new StringBuffer(a).reverse().toString();
        String re_b = new StringBuffer(b).reverse().toString();
        StringBuffer ans = new StringBuffer();
        int carry = 0;
        int n = Math.max(re_a.length(), re_b.length());
        for(int i = 0; i < n; ++i) {
            int ca = (i>=re_a.length()) ? 0 : re_a.charAt(i)-'0';
            int cb = (i>=re_b.length()) ? 0 : re_b.charAt(i)-'0';
            ans.append(ca^cb^carry);
            carry = ca&cb | (ca&(~cb)|(~ca)&cb)&carry;
        }
        if (carry == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}
