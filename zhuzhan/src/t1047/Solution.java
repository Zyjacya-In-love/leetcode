package t1047;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 * @author xzq
 * @create 2022-05-21-10:05
 */
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sb.length() != 0 && sb.charAt(sb.length()-1) == ch) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
// 通过   13 ms	41.7 MB