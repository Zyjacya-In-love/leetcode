package t28;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * @author xzq
 * @create 2022-04-18-21:52
 */
// 字符串匹配 KMP
//class Solution {
//    public int strStr(String haystack, String needle) {
//        int n = haystack.length();
//        int m = needle.length();
//        int[] next = new int[m];
//        for (int i = 1, j = 0; i < m; i++) {
//            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
//                j = next[j-1];
//            }
//            if (needle.charAt(j) == needle.charAt(i)) {
//                j++;
//            }
//            next[i] = j;
//        }
//        for (int i = 0, j = 0; i < n; i++) {
//            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
//                j = next[j-1];
//            }
//            if (needle.charAt(j) == haystack.charAt(i)) {
//                j++;
//            }
//            if (j == m) {
//                return i-m+1;
//            }
//        }
//        return -1;
//    }
//}

/*
 * @create 2022-05-20-15:40
 */
class Solution {
    public int strStr(String s, String p) {
        int[] next = new int[p.length()];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j-1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j-1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                return i-p.length()+1;
            }
        }
        return -1;
    }
}
// 通过   1 ms	39.1 MB