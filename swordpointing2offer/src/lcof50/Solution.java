package lcof50;

import java.util.HashSet;

/**
 * 面试题50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @author xzq
 * @create 2022-03-10-13:51
 */
class Solution {
    public char firstUniqChar(String s) {
        char ans = ' ';
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)-'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
