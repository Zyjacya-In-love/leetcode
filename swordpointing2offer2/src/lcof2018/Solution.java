package lcof2018;

/**
 * 剑指 Offer II 018. 有效的回文
 * https://leetcode-cn.com/problems/XltzEq/
 * @author xzq
 * @create 2022-03-08-9:27
 */
public class Solution {
    public boolean isPalindrome(String s) {
        String sab = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                sab += s.charAt(i);
            }
        }
        return sab.toLowerCase().equals(new StringBuffer(sab.toLowerCase()).reverse().toString());
    }
}
