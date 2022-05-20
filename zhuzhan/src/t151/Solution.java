package t151;

/**
 * 151. 颠倒字符串中的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * @author xzq
 * @create 2022-05-19-20:35
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                int end = i;
                while (i >= 0 && s.charAt(i) != ' ') i--;
                int start = i;
                for (int j = start+1; j <= end; j++) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
// 通过   3 ms	40.9 MB