package t242;


/**
 * 242. 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/
 * @author xzq
 * @create 2022-05-18-8:23
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCnt = new int[30];
        int[] tCnt = new int[30];
        for (int i = 0; i < s.length(); i++) {
            sCnt[s.charAt(i)-'a']++;
            tCnt[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCnt[i] != tCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
// 通过   4 ms	41.2 MB