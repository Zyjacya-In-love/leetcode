package lcof2014;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 * https://leetcode-cn.com/problems/MPnaiL/
 * @author xzq
 * @create 2022-03-08-9:24
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1ab = new int[26];
        int[] s2ab = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1ab[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            s2ab[s2.charAt(i)-'a']++;
        }
        if (check14(s1ab, s2ab)) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            s2ab[s2.charAt(i)-'a']++;
            s2ab[s2.charAt(i-s1.length())-'a']--;
            if (check14(s1ab, s2ab)) return true;
        }
        return false;
    }
    public boolean check14(int[] s1ab, int[] s2ab) {
        for (int i = 0; i < s1ab.length; i++) {
            if (s1ab[i] != s2ab[i]) return false;
        }
        return true;
    }
}
