package t383;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/
 * @author xzq
 * @create 2022-05-18-8:29
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] record = new int[30];
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            record[ransomNote.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
// 通过   1 ms	41.6 MB