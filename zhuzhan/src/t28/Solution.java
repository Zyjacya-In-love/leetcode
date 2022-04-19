package t28;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * @author xzq
 * @create 2022-04-18-21:52
 */
// 字符串匹配 KMP
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j-1];
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j-1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == m) {
                return i-m+1;
            }
        }
        return -1;
    }
}
