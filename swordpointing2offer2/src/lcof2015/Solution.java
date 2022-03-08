package lcof2015;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 * https://leetcode-cn.com/problems/VabMRr/
 * @author xzq
 * @create 2022-03-08-9:26
 */
public class Solution {
    public boolean check15(int[] s1ab, int[] s2ab) {
        for (int i = 0; i < s1ab.length; i++) {
            if (s1ab[i] != s2ab[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();
        int[] sab = new int[26];
        int[] pab = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pab[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            sab[s.charAt(i)-'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (check15(sab, pab)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            sab[s.charAt(i)-'a']++;
            sab[s.charAt(i-p.length())-'a']--;
            if (check15(sab, pab)) res.add(i-p.length()+1);
        }
        return res;
    }
}
